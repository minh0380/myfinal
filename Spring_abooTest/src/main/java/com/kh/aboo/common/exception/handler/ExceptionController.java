package com.kh.aboo.common.exception.handler;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kh.aboo.common.exception.CustomException;

@Controller
//지정한 패키지 내의 모든 컨트롤러들의 공통관심사를 처리하는 클래스
@ControllerAdvice(basePackages = {"com.kh.toy", "common"})
public class ExceptionController {
	
	Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(CustomException.class)
	public String businessExceptionHandler(CustomException e, Model model) {
		
		model.addAttribute("alertMsg", e.error.errMsg());
		model.addAttribute("url", e.error.url());
		
		return "common/result";
		
	}
	
	//응답 상태코드 지정
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(/*HttpServletResponse res, */DataAccessException e, Model model) {
		
		//res.setStatus(500); 이걸 어노테이션 @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)로 바꿀 수 있는 것임.
		//이게 원래 서블릿에서 에러가 나면 서블릿에서 에러 메세지를 만들어 보내주기 때문에 그때 에러코드도 500번대, 400번대 등으로 설정해주는 것임.
		//서블릿에서 설정 해주지 않으면 어쨌든 통신은 성공했으니까 200번으로 날아가게 됨.
		//그래서 login.jsp에서 response.ok가 true라서 then을 타게 되기 때문에 우리가 설정한 alertMsg가 안뜬거임.
		//그냥 response에서 넘긴 fail을 타고 넘어가서 /index로 이동하는 것으로 처리됨.
		//그래서 우린 @ResponseStatus를 통해 상태를 500번(INERNAL_SERVER_ERROR)로 설정해준 것임.
		e.printStackTrace();
		model.addAttribute("alertMsg", "데이터베이스 접근 도중 에러가 발생하였습니다.");
		model.addAttribute("url", "/index");
		
		return "common/result";
		
	}
	
}
