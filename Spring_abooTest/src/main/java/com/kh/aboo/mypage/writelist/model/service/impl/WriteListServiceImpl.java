package com.kh.aboo.mypage.writelist.model.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.aboo.common.util.paging.Paging;
import com.kh.aboo.mypage.writelist.model.repository.WriteListRepository;
import com.kh.aboo.mypage.writelist.model.service.WriteListService;

@Service
public class WriteListServiceImpl implements WriteListService {
	
	private final WriteListRepository writeListRepository;
	
	public WriteListServiceImpl(WriteListRepository writeListRepository) {
		this.writeListRepository = writeListRepository;
	}

	@Override
	public Map<String, Object> selectMyInteriorBrdList(int currentPage, String apartmentIdx, String generationIdx) {
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("myintlist")
				.total(writeListRepository.selectMyInteriorBrdCnt(apartmentIdx, generationIdx))
				.build();
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("paging", paging);
		commandMap.put("board", writeListRepository.selectMyInteriorBrdList(paging.getQueryStart(), paging.getQueryEnd(), apartmentIdx, generationIdx));
		
		return commandMap;
	}

	@Override
	public Map<String, Object> selectMyUsedBrdList(int currentPage, String apartmentIdx, String generationIdx) {
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("myusedlist")
				.total(writeListRepository.selectMyUsedBrdCnt(apartmentIdx, generationIdx))
				.build();
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("paging", paging);
		commandMap.put("board", writeListRepository.selectMyUsedBrdList(paging.getQueryStart(), paging.getQueryEnd(), apartmentIdx, generationIdx));
		
		return commandMap;
	}

	@Override
	public Map<String, Object> selectMyInfoBrdList(int currentPage, String apartmentIdx, String generationIdx) {
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("myinfolist")
				.total(writeListRepository.selectMyInfoBrdCnt(apartmentIdx, generationIdx))
				.build();
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("paging", paging);
		commandMap.put("board", writeListRepository.selectMyInfoBrdList(paging.getQueryStart(), paging.getQueryEnd(), apartmentIdx, generationIdx));
		
		return commandMap;
	}
	
}
