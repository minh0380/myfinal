package com.kh.aboo.bdmin.notice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.aboo.bdmin.model.vo.Bdmin;
import com.kh.aboo.bdmin.notice.model.service.NoticeService;
import com.kh.aboo.bdmin.notice.model.vo.Notice;
import com.kh.aboo.user.manager.model.vo.Admin;

@RequestMapping("bdmin/notice")
@Controller
public class NoticeController {
	
	private final NoticeService noticeService;
	
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@GetMapping("noticelist")
	public String noticeList(@RequestParam(defaultValue = "1") int page
			, Model model
			, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		Bdmin bdmin = (Bdmin) session.getAttribute("bdmin");
		
		if(admin == null && bdmin == null) {
			model.addAttribute("alertMsg", "관리자 로그인 후 서비스를 이용하실 수 있습니다.");
			model.addAttribute("url", "/admin/login");
			
			return "common/result";
		}
		
		model.addAllAttributes(noticeService.selectNoticeList(page));
		
		return "bdmin/notice/noticelist";
	}
	
	@GetMapping("noticeupload")
	public String noticeUpload() {
		return "bdmin/notice/noticeupload";
	}
	
	@PostMapping("noticeuploadimpl")
	public String noticeUploadImpl(Notice notice, Model model, HttpSession session) {
		Bdmin bdmin = (Bdmin) session.getAttribute("bdmin");
		if(bdmin == null) {
			model.addAttribute("alertMsg", "ABOO 관리자 로그인 후 공지사항을 등록할 수 있습니다.");
			model.addAttribute("url", "/bdmin/login");
			
			return "common/result";
		}
		
		int res = noticeService.insertNotice(notice);
		if(res > 0) {
			model.addAttribute("alertMsg", "공지사항이 등록되었습니다.");
			model.addAttribute("url", "/bdmin/notice/noticelist");
		}else {
			model.addAttribute("alertMsg", "공지사항 등록 중 에러가 발생헸습니다.");
			model.addAttribute("url", "/bdmin/notice/noticelist");
		}
		
		return "common/result";
	}
	
	@GetMapping("noticedetail")
	public String noticeDetail(String nNo, Model model) {
		Notice notice = noticeService.selectNoticeByIdx(nNo);
		model.addAttribute("notice", notice);
		
		return "bdmin/notice/noticedetail";
	}
	
	@GetMapping("noticemodify")
	public String noticeModifiy(String nNo, Model model) {
		Notice notice = noticeService.selectNoticeByIdx(nNo);
		String ctnt = notice.getnContent().replace(System.getProperty("line.separator").toString(),"");
		model.addAttribute("notice", notice);
		model.addAttribute("ctnt", ctnt);
		
		return "bdmin/notice/noticemodify";
	}
	
	@PostMapping("noticemodifyimpl")
	public String noticeModifyImpl(Notice notice, Model model, HttpSession session) {
		Bdmin bdmin = (Bdmin) session.getAttribute("bdmin");
		if(bdmin == null) {
			model.addAttribute("alertMsg", "ABOO 관리자 로그인 후 공지사항을 수정할 수 있습니다.");
			model.addAttribute("url", "/bdmin/login");
			
			return "common/result";
		}
		
		int res = noticeService.updateNotice(notice);
		if(res > 0) {
			model.addAttribute("alertMsg", "공지사항이 수정되었습니다.");
			model.addAttribute("url", "/bdmin/notice/noticedetail?nNo=" + notice.getnNo());
		}else {
			model.addAttribute("alertMsg", "공지사항이 수정 중 에러가 발생했습니다.");
			model.addAttribute("url", "/bdmin/notice/noticedetail?nNo=" + notice.getnNo());
		}
		
		return "common/result";
	}
	
	@GetMapping("noticedelete")
	public String noticeDelete(String nNo, Model model, HttpSession session) {
		Bdmin bdmin = (Bdmin) session.getAttribute("bdmin");
		if(bdmin == null) {
			model.addAttribute("alertMsg", "ABOO 관리자 로그인 후 공지사항을 삭제할 수 있습니다.");
			model.addAttribute("url", "/bdmin/login");
			
			return "common/result";
		}
		
		int res = noticeService.deleteNotice(nNo);
		if(res > 0) {
			model.addAttribute("alertMsg", "공지사항이 삭제되었습니다.");
			model.addAttribute("url", "/bdmin/notice/noticelist");
		}else {
			model.addAttribute("alertMsg", "공지사항이 삭제 중 에러가 발생했습니다.");
			model.addAttribute("url", "/bdmin/notice/noticelist");
		}
		
		return "common/result";
	}
	
}
