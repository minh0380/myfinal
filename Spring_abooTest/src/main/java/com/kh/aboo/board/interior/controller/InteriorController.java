package com.kh.aboo.board.interior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("board/interior")
@Controller
public class InteriorController {
	
	@GetMapping("intlist")
	public String intList() {
		return "board/interior/intlist";
	}
	
	@GetMapping("intdetail")
	public String intDetail() {
		return "board/interior/intdetail";
	}
	
	@GetMapping("intupload")
	public String intUpload() {
		return "board/interior/intupload";
	}
	
	@GetMapping("intmodify")
	public String intModify() {
		return "board/interior/intmodify";
	}
	
}
