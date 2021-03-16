package com.kh.toy;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("generation")
	public String index() {
		return "generation/index";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "admin/index";
	}
}
