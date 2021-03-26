package com.kh.aboo.board.interior.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.aboo.board.interior.model.repository.InteriorBrdRepository;
import com.kh.aboo.board.interior.model.service.InteriorService;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;
import com.kh.aboo.common.util.paging.Paging;

@Service
public class InteriorServiceImpl implements InteriorService {
	
	private final InteriorBrdRepository interiorBrdRepository;
	
	public InteriorServiceImpl(InteriorBrdRepository interiorBrdRepository) {
		this.interiorBrdRepository = interiorBrdRepository;
	}

	@Override
	public int insertInteriorBrd(InteriorBrd interiorBrd) {
		return interiorBrdRepository.insertInteriorBrd(interiorBrd);
	}

	@Override
	public InteriorBrd selectInteriorBrdByIdx(String intPostNo) {
		return interiorBrdRepository.selectInteriorBrdByIdx(intPostNo);
	}

	@Override
	public Map<String, Object> selectInteriorBrdList(int currentPage, String apartmentIdx) {
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(6)
				.type("interior")
				.total(interiorBrdRepository.selectInteriorBrdCnt(apartmentIdx))
				.build();
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("paging", paging);
		commandMap.put("interiorBrd", interiorBrdRepository.selectInteriorBrdList(paging.getQueryStart(), paging.getQueryEnd(), apartmentIdx));
		
		return commandMap;
	}
	
}
