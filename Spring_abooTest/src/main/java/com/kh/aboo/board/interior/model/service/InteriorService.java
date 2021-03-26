package com.kh.aboo.board.interior.model.service;

import java.util.Map;

import com.kh.aboo.board.interior.model.vo.InteriorBrd;

public interface InteriorService {
	
	int insertInteriorBrd(InteriorBrd interiorBrd);
	InteriorBrd selectInteriorBrdByIdx(String intPostNo);
	Map<String, Object> selectInteriorBrdList(int currentPage, String apartmentIdx);
	int deleteInteriorBrd(String intPostNo, String apartmentIdx);
	int updateInteriorBrd(InteriorBrd interiorBrd);
	
}
