package com.kh.aboo.admin.index.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin == null) {
			return "admin/login";
		}else {
			//민희 공지사항 index로 보내기
			List<Notice> noticeList = indexNoticeService.selectIndexNotice();
			model.addAttribute("noticeList", noticeList);
		}
		
		return "admin/index";
	}
	
}
