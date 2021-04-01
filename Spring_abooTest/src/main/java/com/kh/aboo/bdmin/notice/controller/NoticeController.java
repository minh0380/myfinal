package com.kh.aboo.bdmin.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("bdmin/notice")
@Controller
public class NoticeController {
	
	@GetMapping("noticelist")
	public String noticeList() {
		return "bdmin/notice/noticelist";
	}
	
	@GetMapping("noticeupload")
	public String noticeUpload() {
		return "bdmin/notice/noticeupload";
	}
	
	@GetMapping("noticedetail")
	public String noticeDetail() {
		return "bdmin/notice/noticedetail";
	}
	
}
