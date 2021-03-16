package com.kh.toy.member.controller;



import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.toy.member.model.service.MemberService;

//Controller 어노테이션이 하는 일 : 해당 클래스가 Controller임을 스프링에게 알려준다.
//해당 클래스를 bean으로 등록. 컨트롤러와 관련된 어노테이션을 해당 클래스내에서 사용할 수 있게 해준다.

//종류
//@RequestMapping : 메서드와 매핑시킬 url 및 http method를 지정
//@GetMapping : 메서드와 매핑시킬 url 지정, get 방식 요청만 매핑된다.
//@PostMapping : 메서드와 매핑시킬 url 지정, post 방식 요청만 매핑된다.
//@RequestParam : 파라미터를 전달받을 수 있다. 파라미터명과 변수명이 일치할 경우에는 생략 가능하다.
//@RequestBody 
//@ModelAttribute
//@ResponseBody : 어노테이션이 작성된 메서드가 반환하는 값을 응답 body에 넣어 응답한다.

// HttpEntity : Http 통신과 관련된 데이터들을 저장하고 있는 객체
// RequestEntity, ResponseEntity : HttpEntity 상속받는다. 

//** 주의사항! **
//Controller의 메서드에 Servlet 객체(HttpServletRequest, HttpServletResponse, Session)를 선언해두면 
//Spring이 메서드 호출할때 Servlet 객체를 담아 보내준다. 
//하지만! 대체할 수 있는 객체를 문서에서 찾는 습관을 들이자.

@RequestMapping("member")
@Controller
public class MemberController {
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	MemberService memberService;
	
	// 생성자로 의존성 주입.
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("join")
	public void join() {}

	@GetMapping("idcheck")
	@ResponseBody // 메서드가 반환하는 값을 응답 body에 담아준다. JSP를 찾지 않는다. 경로재지정이 아닐때 사용한다.
	public String idCheck(String userId) {
		if(memberService.selectMemberById(userId) != null) {
			return "fail";
		}
		return "success";
	}
	
	// 사용자정보 session에 담아두구 메일발송 -> 우리가 지정한 경로로 다시요청하면 그때 session에 담긴 사용자정보 가져와 DB에 넣고 session 삭제.
	// HTTP session을 가져와야겠지? 
	// 스프링의 로우단에 직접 접근하는건 좋은 방법은 아님 request, response 만지는 것! 하지만 session은 예외이다.ㅎ
	@PostMapping("mailauth")
	public String authenicateEmail(@RequestParam Map<String, String> persistInfo, HttpSession session, Model model) {
		session.setAttribute("persistUser", persistInfo);
		memberService.authenicateEmail(persistInfo);
		return "index/index";
		
	}
}
