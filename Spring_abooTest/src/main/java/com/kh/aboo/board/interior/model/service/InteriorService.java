package com.kh.aboo.board.interior.model.service;

import java.util.List;
import java.util.Map;

import com.kh.aboo.board.interior.model.vo.IntCmt;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;

public interface InteriorService {
	
	//InteriorBrd
	int insertInteriorBrd(InteriorBrd interiorBrd);
	InteriorBrd selectInteriorBrdByIdx(String intPostNo);
	Map<String, Object> selectInteriorBrdList(int currentPage, String apartmentIdx);
	int deleteInteriorBrd(String intPostNo, String apartmentIdx);
	int updateInteriorBrd(InteriorBrd interiorBrd);
	
	//IntCmt
	int insertIntCmt(IntCmt intCmt);
	List<IntCmt> selectIntCmtByIntPostNo(String intPostNo);
	int selectIntCmtCnt(String intPostNo);
	int deleteIntCmt(String intCmtNo);
	
}
