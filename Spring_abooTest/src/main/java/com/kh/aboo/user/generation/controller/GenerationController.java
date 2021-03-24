package com.kh.aboo.user.generation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.aboo.user.generation.model.service.GenerationService;
import com.kh.aboo.user.generation.model.vo.Generation;

@Controller
public class GenerationController {

	private final GenerationService generationService;

	public GenerationController(GenerationService generationService) {
		this.generationService = generationService;
	}

	@GetMapping("login")
	public String login() {
		return "generation/login";
	}

	@PostMapping("loginimpl")
	@ResponseBody
	public String loginimpl(@RequestBody Generation generationInfo, HttpSession session) {

		//generationInfo : 받아와서 맵핑 해주는 객체 이름
		//generation : 진짜 generation 정보가 담긴 객체 이름
		
		Generation generation = generationService.selectGenerationForAuth(generationInfo);
		if (generation == null) {
			return "fail";
		}
		session.setAttribute("generation", generation);
		return "sussece";
		
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("generation");
		return "index";
	}

}
