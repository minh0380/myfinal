package com.kh.aboo.board.interior.model.service;

import com.kh.aboo.board.interior.model.vo.InteriorBrd;

public interface InteriorService {
	
	int insertInteriorBrd(InteriorBrd interiorBrd);
	InteriorBrd selectInteriorBrdByIdx(String intPostNo);
	
}
