package com.kh.aboo.myapt.vote.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.aboo.admin.vote.model.service.AdminVoteService;
import com.kh.aboo.admin.vote.model.vo.VoteMng;
import com.kh.aboo.myapt.vote.model.service.VoteService;
import com.kh.aboo.user.generation.model.vo.Generation;
import com.kh.aboo.user.manager.model.vo.Admin;

@RequestMapping("myapt/vote")
@Controller
public class VoteController {
	
	private final AdminVoteService adminVoteService;
	private final VoteService voteService;
	
	public VoteController(AdminVoteService adminVoteService, VoteService voteService) {
		this.adminVoteService = adminVoteService;
		this.voteService = voteService;
	}
	
	@GetMapping("votelist")
	public String voteList(@RequestParam(defaultValue = "1") int page
			, Model model
			, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		Admin admin = (Admin) session.getAttribute("admin");
		
		if(generation != null) {
			model.addAllAttributes(adminVoteService.selectVoteMngList(page, generation.getApartmentIdx()));
		}else {
			model.addAllAttributes(adminVoteService.selectVoteMngList(page, admin.getApartmentIdx()));
		}
		
		return "myapt/vote/votelist";
		
	}
	
	@GetMapping("votedetail")
	public String voteDetail(String voteNo, Model model) {
		VoteMng voteMng = adminVoteService.selectVoteMngByIdx(voteNo);
		String items = voteMng.getVoteItem();
		String[] itemArr = items.split(",");
		
		List<String> itemList = new ArrayList<>();
		for (String item : itemArr) {
			itemList.add(item);
		}
		
		
		model.addAttribute("voteMng", voteMng);
		model.addAttribute("itemList", itemList);
		
		return "myapt/vote/votedetail";
	}
	
	@GetMapping("authvote")
	public String makeVote(String voteNo, Model model) {
		model.addAttribute("voteNo", voteNo);
		
		return "myapt/vote/authvote";
	}
	
	@GetMapping("certsms")
	@ResponseBody
	public String certSms(String tell) {
		voteService.authToVote(tell);
		return "success";
	}
	
}
