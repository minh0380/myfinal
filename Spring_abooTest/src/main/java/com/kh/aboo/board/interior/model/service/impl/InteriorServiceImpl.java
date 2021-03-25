package com.kh.aboo.board.interior.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.aboo.board.interior.model.repository.InteriorBrdRepository;
import com.kh.aboo.board.interior.model.service.InteriorService;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;

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
	public List<InteriorBrd> selectAllInteriorBrd() {
		return interiorBrdRepository.selectAllInteriorBrd();
	}
	
}
