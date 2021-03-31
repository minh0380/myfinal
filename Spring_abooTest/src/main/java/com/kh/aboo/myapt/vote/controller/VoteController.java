package com.kh.aboo.myapt.vote.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.aboo.admin.vote.model.service.AdminVoteService;
import com.kh.aboo.admin.vote.model.vo.VoteMng;
import com.kh.aboo.myapt.vote.model.service.VoteService;
import com.kh.aboo.myapt.vote.model.vo.AuthToVote;
import com.kh.aboo.myapt.vote.model.vo.VoteGen;
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
		List<String> ifParticipate = new ArrayList<>();
		String isDone;
		
		if(generation != null) {
			List<VoteMng> voteMngList = new ArrayList<>();
			voteMngList = (List<VoteMng>) adminVoteService.selectVoteMngList(page, generation.getApartmentIdx()).get("voteMng");
			for (VoteMng voteMng : voteMngList) {
				int res = voteService.selectIfParticipate(generation.getGenerationIdx(), voteMng.getVoteNo());
				if(res != 0) {
					isDone = "참여";
				}else {
					isDone = "미참여";
				}
				
				ifParticipate.add(isDone);
			}
			
			model.addAttribute("ifParticipate", ifParticipate);
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
		
		if(voteMng.getVoteIsFinish() != 0) {
			List<Double> turnoutList = voteService.calculateTurnout(voteNo);
			double maxTurnout = Collections.max(turnoutList);
			int idxOfMax = turnoutList.indexOf(maxTurnout);
			model.addAttribute("turnoutList", turnoutList);
			model.addAttribute("maxTurnout", maxTurnout);
			model.addAttribute("idxOfMax", idxOfMax);
		}
		
		model.addAttribute("voteMng", voteMng);
		model.addAttribute("itemList", itemList);
		
		return "myapt/vote/votedetail";
	}
	
	@GetMapping("authvote")
	public String authVote(String voteNo, Model model, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		int res = voteService.selectIfParticipate(generation.getGenerationIdx(), voteNo);
		
		if(res > 0) {
			model.addAttribute("alertMsg", "이미 투표에 참여하셨습니다.");
			model.addAttribute("url", "/myapt/vote/votelist");
			return "common/result";
		}
		
		model.addAttribute("voteNo", voteNo);
		
		return "myapt/vote/authvote";
	}
	
	@GetMapping("certsms")
	@ResponseBody
	public String certSms(String tell, HttpSession session) {
		int res = voteService.authToVote(tell, session);
		
		if(res == 202) {
			return "success";
		}
		
		return "fail";
	}
	
	@GetMapping("certconfirm")
	@ResponseBody
	public String certConfirm(String certNumber, HttpSession session) {
		String rightNumber = (String) session.getAttribute("certNumToVote");
		
		if(certNumber.equals(rightNumber)) {
			return "success";
		}
		
		return "fail";
	}
	
	@PostMapping("authvoteimpl")
	public String authVoteImpl(AuthToVote authToVote, Model model, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		String generationWonIdxToVote = voteService.selectGenerationWonIdxToVote(authToVote);
		String generationWonTellToVote = voteService.selectGenerationWonTellToVote(authToVote);
		session.setAttribute("generationWonIdxToVote", generationWonIdxToVote);
		session.setAttribute("generationWonTellToVote", generationWonTellToVote);
		int res = voteService.selectGenerationWonToAuth(authToVote);
		
		if(res > 0 && generation.getGenerationIdx().equals(voteService.selectGenerationIdxToConfirm(generationWonIdxToVote))) {
			session.removeAttribute("certNumToVote");
			model.addAttribute("alertMsg", "세대원 인증이 완료되었습니다. 투표를 진행합니다.");
			model.addAttribute("url", "/myapt/vote/dovote?voteNo=" + authToVote.getVoteNo());
		}else {
			model.addAttribute("alertMsg", "세대 정보와 세대원 정보를 다시 확인해주세요.");
			model.addAttribute("url", "/myapt/vote/authvote?voteNo=" + authToVote.getVoteNo());
		}
		
		//꼭 지우기!!!!
		//model.addAttribute("alertMsg", "세대원 인증이 완료되었습니다. 투표를 진행합니다.");
		//model.addAttribute("url", "/myapt/vote/dovote?voteNo=" + authToVote.getVoteNo());
		
		return "common/result";
	}
	
	@GetMapping("dovote")
	public String doVote(String voteNo, Model model) {
		VoteMng voteMng = adminVoteService.selectVoteMngByIdx(voteNo);
		String items = voteMng.getVoteItem();
		String[] itemArr = items.split(",");
		
		List<String> itemList = new ArrayList<>();
		for (String item : itemArr) {
			itemList.add(item);
		}
		
		
		model.addAttribute("voteMng", voteMng);
		model.addAttribute("itemList", itemList);
		
		return "myapt/vote/dovote";
	}
	
	@PostMapping("dovoteimpl")
	public String doVoteImpl(VoteGen voteGen, HttpSession session, Model model) {
		String generationWonIdxToVote = (String) session.getAttribute("generationWonIdxToVote");
		String generationWonTellToVote = (String) session.getAttribute("generationWonTellToVote");
		voteGen.setGenerationWonIdx(generationWonIdxToVote);
		voteGen.setVoteGenwonTell(generationWonTellToVote);
		
		int res = voteService.insertVoteGen(voteGen);
		
		if(res > 0) {
			session.removeAttribute("certNumToVote");
			model.addAttribute("alertMsg", "투표가 완료되었습니다. 참여해주셔서 감사합니다.");
			model.addAttribute("url", "/myapt/vote/votelist");
		}else {
			model.addAttribute("alertMsg", "투표 참여 중 에러가 발생했습니다.");
			model.addAttribute("url", "/myapt/vote/votelist");
		}
		
		return "common/result";
	}
	
	@GetMapping("votesearch")
	public String voteSearch(String voteSearch
			, @RequestParam(defaultValue = "1") int page
			, Model model
			, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		Admin admin = (Admin) session.getAttribute("admin");
		session.setAttribute("voteSearch", voteSearch);
		List<String> ifParticipate = new ArrayList<>();
		String isDone;
		
		if(generation != null) {
			List<VoteMng> voteMngList = new ArrayList<>();
			voteMngList = (List<VoteMng>) adminVoteService.selectVoteMngSearchList(page, generation.getApartmentIdx(), voteSearch).get("voteMng");
			for (VoteMng voteMng : voteMngList) {
				int res = voteService.selectIfParticipate(generation.getGenerationIdx(), voteMng.getVoteNo());
				if(res != 0) {
					isDone = "참여";
				}else {
					isDone = "미참여";
				}
				
				ifParticipate.add(isDone);
			}
			
			model.addAttribute("ifParticipate", ifParticipate);
			model.addAllAttributes(adminVoteService.selectVoteMngSearchList(page, generation.getApartmentIdx(), voteSearch));
			model.addAttribute("voteSearch", voteSearch);
		}else {
			model.addAllAttributes(adminVoteService.selectVoteMngSearchList(page, admin.getApartmentIdx(), voteSearch));
			model.addAttribute("voteSearch", voteSearch);
		}
		
		return "myapt/vote/votesearch";
	}
	
}
