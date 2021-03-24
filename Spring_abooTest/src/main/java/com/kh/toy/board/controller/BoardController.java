package com.kh.toy.board.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.aboo.common.util.file.FileVO;
import com.kh.aboo.common.util.paging.Paging;
import com.kh.toy.board.model.service.BoardService;
import com.kh.toy.board.model.vo.Board;
import com.kh.toy.member.model.vo.Member;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@PostMapping("upload")
	public String uploadBoard(@RequestParam List<MultipartFile> files
			, Board board
			//required = false : userInfo가 없으면 null로 내버려두고, 있다면 member에 넣어줘
			, @SessionAttribute(name = "userInfo", required = false) Member member) {
		
		System.out.println("multipartFile list length : " + files.size());
		System.out.println(files.get(0));
		
		//로그인한 회원이라면
		String userId = member==null?"guest":member.getUserId();
		board.setUserId(userId);
		
		boardService.insertBoard(board, files);
		
		//  /index url로 redirect 요청
		return "redirect:/index";
		
	}
	
	@GetMapping("form")
	public String boardForm() {
		return "board/boardForm";
	}
	
	@GetMapping("list")
	public String boardList(@RequestParam(defaultValue = "1") int page
			, Model model) {
		
		model.addAllAttributes(boardService.selectBoardList(page));
		return "board/boardList";
		
	}
	
	@GetMapping("detail")
	public String boardDetail(String bdIdx, Model model) {
		model.addAllAttributes(boardService.selectBoardDetail(bdIdx));
		return "board/boardView";
	}
	
	@GetMapping("download")
	public ResponseEntity<FileSystemResource> downloadFile(FileVO file) {
		
		//http header : content-disposition : attachment, fileName=test
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition
				.builder("attachment")
				.filename(file.getOriginFileName(), Charset.forName("utf-8"))
				.build());
		
		FileSystemResource resource = 
				new FileSystemResource(file.getFullPath() + file.getRenameFileName());
		
		//ResponseEntity.ok() : 200번 응답코드로
		//.headers(headers).body(resource) : header와 body 설정해서 보냄.
		return ResponseEntity.ok().headers(headers).body(resource);
		
	}
	
	//ResponseEntity 안쓰는 방법
	//이 방법쓰면 fileName 인코딩처리를 해줘야 함. >> 인코딩이 어려움...비추...
	/*@GetMapping("download")
	@ResponseBody
	public FileSystemResource downloadFileVerTwo(FileVO file, HttpServletResponse response) {
		
		try {
			response.setHeader("content-disposition", "attachment; filename=" 
			+ URLEncoder.encode(file.getOriginFileName(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileSystemResource resource = 
				new FileSystemResource(file.getFullPath() + file.getRenameFileName());
		
		return resource;
		
	}*/
	
}
