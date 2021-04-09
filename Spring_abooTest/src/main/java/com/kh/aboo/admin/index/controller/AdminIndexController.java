package com.kh.aboo.admin.index.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.aboo.admin.index.model.service.IndexNoticeService;
import com.kh.aboo.bdmin.notice.model.vo.Notice;
import com.kh.aboo.user.manager.model.vo.Admin;

@Controller
public class AdminIndexController {
	
	private final IndexNoticeService indexNoticeService;
	
	public AdminIndexController(IndexNoticeService indexNoticeService) {
		this.indexNoticeService = indexNoticeService;
	}
	
	@GetMapping("admin/index")
	public String admin(HttpSession session, Model model) {
		//민희 공지사항 index로 보내기
		List<Notice> noticeList = indexNoticeService.selectIndexNotice();
		model.addAttribute("noticeList", noticeList);
		
		//비동기 통신
		List<Integer> list = new ArrayList<>();
		list.add(50);
		list.add(80);
		list.add(100);
		list.add(90);
		list.add(100);
		list.add(70);
		model.addAttribute("list", list);
		
		return "admin/index";
	}
	
}

