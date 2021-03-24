package com.kh.aboo.admin.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("admin/vote")
@Controller
public class AdminVoteController {
	
	@GetMapping("makevote")
	public String makeVote() {
		return "admin/vote/makevote";
	}
	
}
