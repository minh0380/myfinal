package com.kh.toy.member.model.service;

import com.kh.toy.member.model.vo.Member;

public interface MemberService {
	
	Member selectMemberById(String userId);
	void authenticateEmail(Member persistInfo, String authPath);
	int selectMemberByEmail(String email);
	int selectMemberByTell(String tell);
	int insertMember(Member persistInfo);
	Member authenticateUser(Member member);
	
}
