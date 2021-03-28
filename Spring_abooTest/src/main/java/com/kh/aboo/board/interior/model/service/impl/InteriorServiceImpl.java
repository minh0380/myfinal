package com.kh.aboo.board.interior.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.aboo.board.interior.model.repository.IntCmtRepository;
import com.kh.aboo.board.interior.model.repository.InteriorBrdRepository;
import com.kh.aboo.board.interior.model.service.InteriorService;
import com.kh.aboo.board.interior.model.vo.IntCmt;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;
import com.kh.aboo.common.util.paging.Paging;

@Service
public class InteriorServiceImpl implements InteriorService {
	
	private final InteriorBrdRepository interiorBrdRepository;
	private final IntCmtRepository intCmtRepository;
	
	public InteriorServiceImpl(InteriorBrdRepository interiorBrdRepository, IntCmtRepository intCmtRepository) {
		this.interiorBrdRepository = interiorBrdRepository;
		this.intCmtRepository = intCmtRepository;
	}
	
	//InteriorBrd

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

	@Override
	public int deleteInteriorBrd(String intPostNo, String apartmentIdx) {
		return interiorBrdRepository.deleteInteriorBrd(intPostNo, apartmentIdx);
	}

	@Override
	public int updateInteriorBrd(InteriorBrd interiorBrd) {
		return interiorBrdRepository.updateInteriorBrd(interiorBrd);
	}
	
	//IntCmt

	@Override
	public int insertIntCmt(IntCmt intCmt) {
		return intCmtRepository.insertIntCmt(intCmt);
	}

	@Override
	public List<IntCmt> selectIntCmtByIntPostNo(String intPostNo) {
		return intCmtRepository.selectIntCmtByIntPostNo(intPostNo);
	}

	@Override
	public int selectIntCmtCnt(String intPostNo) {
		return intCmtRepository.selectIntCmtCnt(intPostNo);
	}

	@Override
	public int deleteIntCmt(String intCmtNo) {
		return intCmtRepository.deleteIntCmt(intCmtNo);
	}

	@Override
	public int updateIntCmt(IntCmt intCmt) {
		return intCmtRepository.updateIntCmt(intCmt);
	}
	
}
