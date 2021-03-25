package com.kh.aboo.board.interior.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kh.aboo.board.interior.model.vo.InteriorBrd;

public interface InteriorService {
	
	//int insertInteriorBrd(InteriorBrd interiorBrd, List<MultipartFile> files);
	int insertInteriorBrd(InteriorBrd interiorBrd);
	InteriorBrd selectInteriorBrdByIdx(String intPostNo);
	List<InteriorBrd> selectAllInteriorBrd();
	
}
