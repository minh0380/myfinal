package common.interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import common.code.ErrorCode;
import common.exception.ToAlertException;

//HandlerInterceptor
public class AuthInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
		
		//session에 userInfo 속성이 없을 경우 mypage로의 접근을 막음
		//session에 psersistInfo 속성이 없을 경우 joinimpl로의 접근을 막음
		HttpSession session = request.getSession();
		String[] uriArr = request.getRequestURI().split("/");
		
		if(uriArr.length > 0) {
			
			switch (uriArr[1]) {
			case "member":
				switch (uriArr[2]) {
				case "mypage":
					if(session.getAttribute("userInfo") == null) {
						throw new ToAlertException(ErrorCode.AUTH01);
					}
				case "joinimpl":
					if(session.getAttribute("persistInfo") == null) {
						throw new ToAlertException(ErrorCode.AUTH02);
					}
				}
				break;
			}
			
		}
		
		return true;
		
	}
	
}
