package com.kh.aboo.myapt.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("myapt/vote")
@Controller
public class VoteController {
	
	@GetMapping("authvote")
	public String makeVote() {
		return "myapt/vote/authvote";
	}
	
}
