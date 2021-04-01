package com.kh.aboo.mypage.writelist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.aboo.mypage.writelist.model.service.WriteListService;
import com.kh.aboo.user.generation.model.vo.Generation;

@RequestMapping("mypage/writelist")
@Controller
public class WriteListController {
	
	private final WriteListService writeListService;
	
	public WriteListController(WriteListService writeListService) {
		this.writeListService = writeListService;
	}
	
	@GetMapping("myintlist")
	public String myInteriorList(@RequestParam(defaultValue = "1") int page
			, Model model
			, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		
		if(generation == null) {
			model.addAttribute("alertMsg", "회원 로그인을 하셔야 이용 가능합니다.");
			model.addAttribute("url", "/login");
			
			return "common/result";
		}
		
		model.addAllAttributes(writeListService.selectMyInteriorBrdList(page, generation.getApartmentIdx(), generation.getGenerationIdx()));
		
		return "mypage/writelist/myintlist";
	}
	
	@GetMapping("myusedlist")
	public String myUsedList(@RequestParam(defaultValue = "1") int page
			, Model model
			, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		
		if(generation == null) {
			model.addAttribute("alertMsg", "회원 로그인을 하셔야 이용 가능합니다.");
			model.addAttribute("url", "/login");
			
			return "common/result";
		}
		
		model.addAllAttributes(writeListService.selectMyUsedBrdList(page, generation.getApartmentIdx(), generation.getGenerationIdx()));
		
		return "mypage/writelist/myusedlist";
	}
	
	@GetMapping("myinfolist")
	public String myInfoList(@RequestParam(defaultValue = "1") int page
			, Model model
			, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		
		if(generation == null) {
			model.addAttribute("alertMsg", "회원 로그인을 하셔야 이용 가능합니다.");
			model.addAttribute("url", "/login");
			
			return "common/result";
		}
		
		model.addAllAttributes(writeListService.selectMyInfoBrdList(page, generation.getApartmentIdx(), generation.getGenerationIdx()));
		
		return "mypage/writelist/myinfolist";
	}
	
}
