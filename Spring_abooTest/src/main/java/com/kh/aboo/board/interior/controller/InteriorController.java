package com.kh.aboo.board.interior.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.aboo.board.interior.model.service.InteriorService;
import com.kh.aboo.board.interior.model.vo.IntCmt;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;
import com.kh.aboo.user.generation.model.vo.Generation;
import com.kh.aboo.user.manager.model.vo.Admin;

@RequestMapping("board/interior")
@Controller
public class InteriorController {
	
	private final InteriorService interiorService;
	
	public InteriorController(InteriorService interiorService) {
		this.interiorService = interiorService;
	}
	
	@GetMapping("intlist")
	public String intList(@RequestParam(defaultValue = "1") int page
			, Model model
			, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		Admin admin = (Admin) session.getAttribute("admin");
				
		if(generation != null) {
			Map<String, Object> commandMap = interiorService.selectInteriorBrdList(page, generation.getApartmentIdx());
			List<InteriorBrd> interiorBrd = (List<InteriorBrd>) commandMap.get("interiorBrd");
			List<Integer> intCmtCntList = new ArrayList<>();
			
			for (InteriorBrd intBrd : interiorBrd) {
				int intCmt = interiorService.selectIntCmtCnt(intBrd.getIntPostNo());
				intCmtCntList.add(intCmt);
			}
			
			model.addAllAttributes(interiorService.selectInteriorBrdList(page, generation.getApartmentIdx()));
			model.addAttribute("intCmtCntList", intCmtCntList);
		}else {
			Map<String, Object> commandMap = interiorService.selectInteriorBrdList(page, admin.getApartmentIdx());
			List<InteriorBrd> interiorBrd = (List<InteriorBrd>) commandMap.get("interiorBrd");
			List<Integer> intCmtCntList = new ArrayList<>();
			
			for (InteriorBrd intBrd : interiorBrd) {
				int intCmt = interiorService.selectIntCmtCnt(intBrd.getIntPostNo());
				intCmtCntList.add(intCmt);
			}
			
			model.addAllAttributes(interiorService.selectInteriorBrdList(page, admin.getApartmentIdx()));
			model.addAttribute("intCmtCntList", intCmtCntList);
		}
		
		return "board/interior/intlist";
	}
	
	@GetMapping("intdetail")
	public String intDetail(String intPostNo, Model model) {
		InteriorBrd interiorBrd = interiorService.selectInteriorBrdByIdx(intPostNo);
		model.addAttribute("interiorBrd", interiorBrd);
		
		List<IntCmt> intCmtList = interiorService.selectIntCmtByIntPostNo(intPostNo);
		model.addAttribute("intCmtList", intCmtList);
		
		int intCmtCnt = interiorService.selectIntCmtCnt(intPostNo);
		model.addAttribute("intCmtCnt", intCmtCnt);
		
		return "board/interior/intdetail";
	}
	
	@GetMapping("intupload")
	public String intUpload() {
		return "board/interior/intupload";
	}
	
	@PostMapping("intuploadimpl")
	public String intUploadImpl(InteriorBrd interiorBrd
			, Model model
			, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		if(generation == null) {
			model.addAttribute("alertMsg", "회원 로그인을 하셔야 글을 작성하실 수 있습니다.");
			model.addAttribute("url", "/board/interior/intlist");
			
			return "common/result";
		}
		
		interiorBrd.setApartmentIdx(generation.getApartmentIdx());
		interiorBrd.setIntWriter(generation.getBuilding() + "동 " + generation.getNum() + "호");
		interiorBrd.setGenerationIdx(generation.getGenerationIdx());
		
		Document doc = Jsoup.parse(interiorBrd.getIntContent());
		Elements img = doc.select("img");
		
		List<String> imgs = new ArrayList<>();
		for (Element element : img) {
			Node node = element;
			String imgUrl = node.attr("src");
			imgs.add(imgUrl);
		}
		
		if(imgs.isEmpty()) {
			interiorBrd.setIntThumbnail("../../../resources/abooimg/nopreviewimg.jpg");
		}else {
			interiorBrd.setIntThumbnail(imgs.get(0));
		}
		
		int res = interiorService.insertInteriorBrd(interiorBrd);
		if(res > 0) {
			model.addAttribute("alertMsg", "게시물이 등록되었습니다.");
			model.addAttribute("url", "/board/interior/intlist");
		}else {
			model.addAttribute("alertMsg", "게시물 등록 도중 에러가 발생했습니다.");
			model.addAttribute("url", "/board/interior/intlist");
		}
		
		return "common/result";
	}
	
	@GetMapping("intmodify")
	public String intModify(String intPostNo, Model model) {
		InteriorBrd interiorBrd = interiorService.selectInteriorBrdByIdx(intPostNo);
		String ctnt = interiorBrd.getIntContent().replace(System.getProperty("line.separator").toString(),"");
		model.addAttribute("interiorBrd", interiorBrd);
		model.addAttribute("intContent", ctnt);
		return "board/interior/intmodify";
	}
	
	@PostMapping("intmodifyimpl")
	public String intModifyImpl(InteriorBrd interiorBrd, String intPostNo, Model model) {
		interiorBrd.setIntPostNo(intPostNo);
		
		Document doc = Jsoup.parse(interiorBrd.getIntContent());
		Elements img = doc.select("img");
		
		List<String> imgs = new ArrayList<>();
		for (Element element : img) {
			Node node = element;
			String imgUrl = node.attr("src");
			imgs.add(imgUrl);
		}
		
		if(imgs.isEmpty()) {
			interiorBrd.setIntThumbnail("../../../resources/abooimg/nopreviewimg.jpg");
		}else {
			interiorBrd.setIntThumbnail(imgs.get(0));
		}
		
		int res = interiorService.updateInteriorBrd(interiorBrd);
		
		if(res > 0) {
			model.addAttribute("alertMsg", "게시물이 수정되었습니다.");
			model.addAttribute("url", "/board/interior/intlist");
		}else {
			model.addAttribute("alertMsg", "게시물 수정 도중 에러가 발생했습니다.");
			model.addAttribute("url", "/board/interior/intlist");
		}
		
		return "common/result";
	}
	
	@GetMapping("intdelete")
	@ResponseBody
	public String intDelete(String intPostNo, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		int res = interiorService.deleteInteriorBrd(intPostNo, generation.getApartmentIdx());
		
		if(res > 0) {
			return "success";
		}
		
		return "fail";
	}
	
	@PostMapping("intcmtupload")
	public String intCmtUpload(IntCmt intCmt, Model model, HttpSession session) {
		Generation generation = (Generation) session.getAttribute("generation");
		intCmt.setIntCmtWriter(generation.getBuilding() + "동 " + generation.getNum() + "호");
		int res = interiorService.insertIntCmt(intCmt);
		
		if(res > 0) {
			model.addAttribute("alertMsg", "댓글이 등록되었습니다.");
			model.addAttribute("url", "/board/interior/intdetail?intPostNo=" + intCmt.getIntPostNo());
		}else {
			model.addAttribute("alertMsg", "댓글 등록 도중 에러가 발생했습니다.");
			model.addAttribute("url", "/board/interior/intdetail?intPostNo=" + intCmt.getIntPostNo());
		}
		
		return "common/result";
	}
	
	@GetMapping("intcmtdelete")
	@ResponseBody
	public String intCmtDelete(String intCmtNo) {
		int res = interiorService.deleteIntCmt(intCmtNo);
		
		if(res > 0) {
			return "success";
		}
		
		return "fail";
	}
	
	@PostMapping("intcmtmodify")
	public String intCmtModify(IntCmt intCmt, Model model) {
		int res = interiorService.updateIntCmt(intCmt);
		
		if(res > 0) {
			model.addAttribute("alertMsg", "댓글이 수정되었습니다.");
			model.addAttribute("url", "/board/interior/intdetail?intPostNo=" + intCmt.getIntPostNo());
		}else {
			model.addAttribute("alertMsg", "댓글 수정 도중 에러가 발생했습니다.");
			model.addAttribute("url", "/board/interior/intdetail?intPostNo=" + intCmt.getIntPostNo());
		}
		
		return "common/result";
	}
	
}
