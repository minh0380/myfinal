package com.kh.toy.member.model.service;

import java.util.Map;
import com.kh.toy.member.model.vo.Member;

public interface MemberService {
	
	// 여기 인터페이스에서 먼저 선언하고 impl에 구현한다.
	Member selectMemberById(String userId);
	
	// 메일발송 선언
	void authenicateEmail(Map<String, String> persistInfo);

}
