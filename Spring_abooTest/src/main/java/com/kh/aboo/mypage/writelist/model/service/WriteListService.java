package com.kh.aboo.mypage.writelist.model.service;

import java.util.Map;

public interface WriteListService {
	
	Map<String, Object> selectMyInteriorBrdList(int currentPage, String apartmentIdx, String generationIdx);
	Map<String, Object> selectMyUsedBrdList(int currentPage, String apartmentIdx, String generationIdx);
	Map<String, Object> selectMyInfoBrdList(int currentPage, String apartmentIdx, String generationIdx);
	
}
