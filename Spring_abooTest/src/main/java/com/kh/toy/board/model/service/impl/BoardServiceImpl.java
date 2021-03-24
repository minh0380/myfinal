package com.kh.toy.board.model.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.aboo.common.code.ErrorCode;
import com.kh.aboo.common.exception.CustomException;
import com.kh.aboo.common.exception.ToAlertException;
import com.kh.aboo.common.util.file.FileUtil;
import com.kh.aboo.common.util.file.FileVO;
import com.kh.aboo.common.util.paging.Paging;
import com.kh.toy.board.model.repository.BoardRepository;
import com.kh.toy.board.model.service.BoardService;
import com.kh.toy.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	//@Transactional //commit과 rollback 관리가 이 메서드 단위로 바뀜.
	public void insertBoard(Board board, List<MultipartFile> files) {
		
		FileUtil fileUtil = new FileUtil();
		boardRepository.insertBoard(board);
		
		try {
			List<FileVO> fileList = fileUtil.fileUpload(files);
			for (FileVO fileVO : fileList) {
				boardRepository.insertFile(fileVO);
			}
		} catch (Exception e) {
			throw new ToAlertException(ErrorCode.IB01, e);
		}
		
	}

	@Override
	public Map<String, Object> selectBoardList(int currentPage) {
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("board")
				.total(boardRepository.selectContentCnt())
				.build();
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("paging", paging);
		commandMap.put("boardList", boardRepository.selectBoardList(paging));
		
		return commandMap;
	}

	@Override
	public Map<String, Object> selectBoardDetail(String bdIdx) {
		Board board = boardRepository.selectBoardDetail(bdIdx);
		List<FileVO> files = boardRepository.selectFileWithBdIdx(bdIdx);
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("board", board);
		commandMap.put("files", files);
		
		return commandMap;
	}
	
}
