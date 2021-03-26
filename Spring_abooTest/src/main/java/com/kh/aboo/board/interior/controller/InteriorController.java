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

import com.kh.aboo.board.interior.model.service.InteriorService;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;

@RequestMapping("board/interior")
@Controller
public class InteriorController {
	
	private final InteriorService interiorService;
	
	public InteriorController(InteriorService interiorService) {
		this.interiorService = interiorService;
	}
	
	@GetMapping("intlist")
	public String intList(@RequestParam(defaultValue = "1") int page
			, Model model) {
		model.addAllAttributes(interiorService.selectInteriorBrdList(page));
		return "board/interior/intlist";
	}
	
	@GetMapping("intdetail")
	public String intDetail(String intPostNo, Model model) {
		InteriorBrd interiorBrd = interiorService.selectInteriorBrdByIdx(intPostNo);
		model.addAttribute("interiorBrd", interiorBrd);
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
		/*Generation generation = (Generation) session.getAttribute("generation");
		if(generation == null) {
			model.addAttribute("alertMsg", "회원 로그인을 하셔야 글을 작성하실 수 있습니다.");
			model.addAttribute("url", "/board/interior/intlist");
			
			return "common/result";
		}*/
		
		//interiorBrd.setApartmentIdx(generation.getApartmentIdx());
		//interiorBrd.setIntWriter(generation.getBuilding() + "동 " + generation.getNum() + "호");
		interiorBrd.setApartmentIdx("100000");
		interiorBrd.setIntWriter("101동 102호");
		
		Document doc = Jsoup.parse(interiorBrd.getIntContent());
		Elements img = doc.select("img");
		List<String> imgs = new ArrayList<>();
		for (Element element : img) {
			Node node = element;
			String imgUrl = node.attr("src");
			imgs.add(imgUrl);
		}
		
		interiorBrd.setIntThumbnail("../../.." + imgs.get(0));
		
		int res = interiorService.insertInteriorBrd(interiorBrd);
		if(res > 0) {
			model.addAttribute("alertMsg", "게시물이 등록되었습니다.");
			model.addAttribute("url", "/board/interior/intlist");
		}else {
			model.addAttribute("alertMsg", "게시물이 등록 도중 에러가 발생했습니다.");
			model.addAttribute("url", "/board/interior/intlist");
		}
		
		return "common/result";
	}
	
	@GetMapping("intmodify")
	public String intModify() {
		return "board/interior/intmodify";
	}
	
}
