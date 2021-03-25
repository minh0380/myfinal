package com.kh.aboo.user.generation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.aboo.user.generation.model.repository.GenerationRepository;
import com.kh.aboo.user.generation.model.service.GenerationService;
import com.kh.aboo.user.generation.model.vo.Generation;
import com.kh.aboo.user.manager.model.vo.Admin;

@Controller
public class GenerationController {
	@Autowired
	private PasswordEncoder encoder;
	
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
		return "index/index";
	}
	
	//세대 추가 메서드 이거 쓰세용 
	@GetMapping("generation/add") 
	public void generationAdd() {
		Generation generation = new Generation();
		generation.setId("101d101h");
		generation.setPassword(encoder.encode("123"));
		generation.setApartmentIdx("100000");
		
		generationService.insertGeneration(generation);
	}

}
