package com.kh.toy.member.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.aboo.common.code.ErrorCode;
import com.kh.aboo.common.exception.ToAlertException;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;
import com.kh.toy.member.validator.MemberValidator;

//Controller : 해당 클래스가 Controller 임을 스프링에 알려준다.
//해당 클래스를 bean으로 등록
//Controller와 관련된 annotation을 해당 클래스 내에서 사용할 수 있게 해준다.
//@RequestMapping : 메서드와 매핑시킬 url 및 http method를 지정
//@GetMapping : 메서드와 매핑 시킬 url 지정, get 방식 요청만 매핑된다.
//@PostMapping : 메서드와 매핑 시킬 url 지정, post 방식 요청만 매핑된다.
//@RequestParam : @RequestParam 어노테이션을 사용해서 파라미터를 전달 받을 수 있다.
//				@RequestParam 어노테이션을 사용해서 파라미터를 바인드 해주는 친구는 FormHttpMessageConverter가 동작
//				FormHttpMessageConverter : form-url-encoded 컨텐츠 타입의 http 메세지를 파싱해서
//					객체에 바인드 해주는 역할을 수행하는 인터페이스
//@RequestBody : MappingJacksonHttpMessageConverter가 동작 application/json 컨텐츠 타입의 메시지를
//				 파싱해서 객체에 바인드 해주는 역할을 수행
//@ModelAttribute : 요청 파라미터를 vo와 바인드, model 객체의 attribute에도 VO를 담는다.
//@ResponseBody : 어노테이션이 작성된 메서드가 반환하는 값을 응답 body에 넣어 응답한다.
//@RequestHeader : 요청 헤더를 컨트롤러 메서드에 바인드
//@SessionAttribute : 원하는 Session의 attribute를 컨트롤러 메서드 파라미터에 바인드
//@PathVariable : url 템플릿에 담긴 파라미터값을 컨트롤러 메서드 파라미터에 바인드
//@CookieValue : 원하는 Cookie를 컨트롤러 메서드 매개변수에 바인드

// HttpEntity : Http 통신과 관련된 데이터들을 저장하고 있는 객체
// RequestEntity, ResponseEntity

// *** Controller의 메서드에 Servlet 객체(Request, Response, Session)를 선언해두면
//		Spring이 메서드를 호출할 때 Servlet 객체를 담아서 보내준다.
//		하지만 대체할 수 있는 객체를 문서에서 찾는 습관을 들이자.

@RequestMapping("member")
@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final MemberService memberService;
	private final MemberValidator memberValidator;
	
	public MemberController(MemberService memberService
			, MemberValidator memberValidator) {
		this.memberService = memberService;
		this.memberValidator = memberValidator;
	}
	
	//@InitBinder : 특정 컨트롤러에서 validator를 사용하기 위해 지정
	//		value : value 속성에 지정한 요청 파라미터명 또는 modelAttribute 명에 대해서만 validator가 동작한다.
	//				@InitBinder("member") 등으로 넣을 수 있다.
	//				MemberValidator에서 clazz 설정 return값 보기.
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		//WebDataBinder : 컨트롤러 메서드의 파라미터에 데이터 바인드 해준다.
		webDataBinder.addValidators(memberValidator);
	}
	
	//view 지정하는 방법
	// 1. ModelAndView 객체를 만들어서 setViewName 메서드에 view 경로를 지정
	// 2. view 경로를 반환
	// 3. 아무것도 반환하지 않을 경우 요청 온 url을 view 경로로 지정
	@GetMapping("join")
	public void join() {};
	
	//parameter
	//@RequestParam 어노테이션을 사용해서 파라미터를 전달 받을 수 있다.
	//name 속성에 전달받고자 하는 파라미터명을 넣어주면, 어노테이션이 지정된 변수에 해당 파라미터를 바인드 해준다.
	//파라미터명과 변수명이 일치할 경우에는 생략이 가능하다.
	//Spring의 httpMessageConverter가 사용자의 http message를 자바 객체로 변환해 바인드 해줌
	@GetMapping("idcheck")
	@ResponseBody //메서드가 반환하는 값을 응답 body에 담아준다.
	public String idCheck(String userId){
		if(memberService.selectMemberById(userId) != null) {
			return "fail";
		}
		
		return "success";
	}
	
	@PostMapping("mailauth")
	//*VO는 @RequestParam 없어도 됨. 자바빈규약에 따른 객체는 스프링이 자동으로 바인드 해줌.
	// VO 앞에 어노테이션을 붙이려면 @ModelAttribute를 붙이는게 맞다. >> 그럼 model.addAttribute로 넣어줌.
	public String authenticateEmail(@Valid Member persistInfo
			, Errors errors //@Valid 어노테이션이 지정된 파리미터 바로 뒤에 위치해야한다.
			, HttpSession session
			, Model model) {
		//debug 돌려보면 에러가 걸렸을 때 Model model에 member라는 키 값으로 Member[userId=...] 객체, 에러값이 넘어온다.
		//>>{member=Member[userId=...], org.springframwork.resultBind.member=["이미 존재하는 아이디입니다."]} 대략적으로 이런 형태.
		
		//test 돌렸을때 ModelAndView에서 Attribute=member로 들어가는건 패키지명을 따서 짓는 듯 하다. >> 스프링이 알아서 넣어주는 것임.
		
		if(errors.hasErrors()) {
			return "member/join";
		}
		
		String authPath = UUID.randomUUID().toString();
		session.setAttribute("authPath", authPath);
		
		//httpRequest나 httpResponse는 로우단이기 때문에 직접 접근하는 게 권장되는 방법은 아님. spring이 관리해주는 걸 접근하는 것이니까.
		//프레임워크가 제공해주는 것을 사용하는 것이 의미가 있는 것임. httpServletRequest를 쓰지 않아도 끌어올 수 있는 방법을 프레임워크가 다 마련해뒀음
		//그걸 찾아보기 싫고 귀찮으니 블로그에선 httpServletRequest를 자주 사용하는 것임.
		//하지만 httpSession은 예외임. attribute별로 상태를 관리하는게 없어서 어쩔 수가 없음.
		session.setAttribute("persistInfo", persistInfo);
		memberService.authenticateEmail(persistInfo, authPath);
		model.addAttribute("alertMsg", "이메일이 전송되었습니다.");
		model.addAttribute("url", "/index");
		
		return "common/result";
	}
	
	/* RequestEntity 사용해보기
	@PostMapping("mailauth")
	public String authenticateEmail(@RequestHeader Map<String, String> headers, RequestEntity<Map> req
			, HttpSession session, Model model) {
		//httpRequest나 httpResponse는 로우단이기 때문에 직접 접근하는 게 권장되는 방법은 아님. spring이 관리해주는 걸 접근하는 것이니까.
		//프레임워크가 제공해주는 것을 사용하는 것이 의미가 있는 것임. httpServletRequest를 쓰지 않아도 끌어올 수 있는 방법을 프레임워크가 다 마련해뒀음
		//그걸 찾아보기 싫고 귀찮으니 블로그에선 httpServletRequest를 자주 사용하는 것임.
		//다음과 같이 HttpServletRequest는 RequestEntity로 대체할 수 있다. req.찍어보면 getHeaders, getBody 등 다 있다.
		//여기서 getBody는 RequestEntity<Map>로 설정했기 때문에 Map로 받는다.
		System.out.println(req.getMethod());
		System.out.println(req.getUrl());
		System.out.println(req.getHeaders());
		System.out.println(headers);
		
		//하지만 httpSession은 예외임. attribute별로 상태를 관리하는게 없어서 어쩔 수가 없음.
		//session.setAttribute("persistUser", persistInfo);
		//System.out.println(session.getAttribute("persistUser"));
		
		return "index/index";
	}*/
	
	//@SessionAttribute를 통해 세션에 담긴 정보를 바로 받을 수 있다.
	@GetMapping("joinimpl/{authPath}")
	public String joinImpl(@PathVariable("authPath") String urlPath
			, @SessionAttribute("authPath") String sessionPath
			, @SessionAttribute("persistInfo") Member persistInfo
			, Model model
			, HttpSession session) {
		
		if(!urlPath.equals(sessionPath)) {
			throw new ToAlertException(ErrorCode.AUTH02);
		}
		
		memberService.insertMember(persistInfo);
		//session.removeAttribute("authPath"); //나의 풀이
		session.removeAttribute("persistInfo");
		model.addAttribute("alertMsg", "회원가입이 완료되었습니다.");
		model.addAttribute("url", "/index");
		
		return "common/result";
		
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("loginimpl")
	@ResponseBody
	public String loginImpl(@RequestBody Member member, HttpSession session) {
		Member userInfo = memberService.authenticateUser(member);
		
		if(userInfo == null) {
			return "fail";
		}
		
		session.setAttribute("userInfo", userInfo);
		
		return "success";
	}
	
	@GetMapping("mypage")
	public String myPage() {
		return "member/mypage";
	}
	
}
