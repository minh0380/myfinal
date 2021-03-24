package com.kh.aboo.myapt.institutions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("myapt")
@Controller
public class InstitutionsController {
	
	@GetMapping("institutions")
	public String intList() {
		return "myapt/institutions/institutions";
	}
	
}
