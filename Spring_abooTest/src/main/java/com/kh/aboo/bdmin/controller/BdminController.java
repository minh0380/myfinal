package com.kh.aboo.bdmin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.aboo.bdmin.model.service.BdminService;
import com.kh.aboo.bdmin.model.vo.Bdmin;

@Controller
public class BdminController {
	
	private final BdminService bdminService;
	
	public BdminController(BdminService bdminService) {
		this.bdminService = bdminService;
	}
	
	@GetMapping("/bdmin/login")
	public void login() {
		
	}
	
	// 로그인성공시 session 넣어주기, 세션명 bdmin
	@PostMapping("/bdmin/loginimpl")
	@ResponseBody
	public String loginImpl(@RequestBody Bdmin bdminInfo, HttpSession session) {
		Bdmin bdmin = bdminService.selectBdminForAuth(bdminInfo);
		
		if(bdmin == null) {
			return "fail";
		}

		session.setAttribute("bdmin", bdmin);
		return "success";
	}
	
	// 로그아웃시 세션지운다.
	@GetMapping("/bdmin/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("bdmin");
		return "redirect:/admin/index";
	}

	
	// 아파트 목록
	@GetMapping("/bdmin/apartment")
	public void apartment(@SessionAttribute(name="bdmin", required = false) Bdmin bdmin, Model model) {
		System.out.println(bdmin);
	}
	
	
}
