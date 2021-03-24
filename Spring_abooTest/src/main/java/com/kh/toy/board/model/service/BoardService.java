package com.kh.toy.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.board.model.vo.Board;

import common.util.paging.Paging;

public interface BoardService {
	
	public void insertBoard(Board board, List<MultipartFile> files);
	public Map<String, Object> selectBoardList(int currentPage);
	public Map<String, Object> selectBoardDetail(String bdIdx);
	
}
