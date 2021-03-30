package com.kh.aboo.user.generation.model.service;

import java.util.Map;

import com.kh.aboo.user.generation.model.vo.Generation;
import com.kh.aboo.user.generationWon.model.vo.GenerationWon;

public interface GenerationService {

	
	Generation selectGenerationForAuth(Generation generation);
	
	void insertGeneration(Generation generation);
	
	//아이디 찾기 전 확인
	Generation selectFindId(Generation generation);
	
	//아이디 찾기 메일
	void authenticationIdMail(Generation generation ,String authPathId);
	
	//비밀번호 찾기 전 확인
	Generation selectFindPassword(Generation generation);
	
	//비밀번호 찾기 메일
	void authenticationPasswordMail(Generation generation, String password);
	
	//선영  세대 리스트
	Map<String,Object> selectGenerationWonList(int currentPage,String apartmentIdx);

	//세대원 수정
	int updateGenerationWonModify(GenerationWon generationWon);
	
	int updateGenerationWonDelete(GenerationWon generationWon);
	
	int insertGenerationWonAdd(GenerationWon generationWon);

	//세대 정보
	Generation selectGeneration(Generation generation);
	
	int updateGenerationModify(Generation generation);
	
	//이메일 인증
	void authenticationEmail(Generation generation ,String authPathEmail);
	
	//이메일 인증 성공시 이메일 업데이트
	int updateGenerationEmail(Generation generation);

}
