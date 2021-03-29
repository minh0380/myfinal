package com.kh.aboo.admin.vote.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.aboo.admin.vote.model.service.AdminVoteService;
import com.kh.aboo.admin.vote.model.vo.VoteMng;
import com.kh.aboo.user.manager.model.vo.Admin;

@RequestMapping("admin/vote")
@Controller
public class AdminVoteController {
	
	private final AdminVoteService adminVoteService;
	
	public AdminVoteController(AdminVoteService adminVoteService) {
		this.adminVoteService = adminVoteService;
	}
	
	@GetMapping("makevote")
	public String makeVote() {
		return "admin/vote/makevote";
	}
	
	@PostMapping("makevoteimpl")
	public String makeVoteImpl(VoteMng voteMng, Model model, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin == null) {
			model.addAttribute("alertMsg", "관리자 로그인을 하셔야 투표를 생성하실 수 있습니다.");
			model.addAttribute("url", "/admin/login");
			
			return "common/result";
		}
		
		voteMng.setApartmentIdx(admin.getApartmentIdx());
		
		int res = adminVoteService.insertVoteMng(voteMng);
		if(res > 0) {
			model.addAttribute("alertMsg", "투표가 생성되었습니다.");
			model.addAttribute("url", "/myapt/vote/votelist");
		}else {
			model.addAttribute("alertMsg", "투표 생성 중 에러가 발생했습니다.");
			model.addAttribute("url", "/myapt/vote/votelist");
		}
		
		return "common/result";
	}
	
}
