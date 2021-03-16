package com.kh.toy.member.model.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;

import common.mail.MailSender;

@Service
public class MemberServiceImpl implements MemberService{

	// 우리가 만든 애들은 싱글톤이고 스레드세이프하지않다.
	// 그래서 생성자주입으로 넣어주겠다.
	private final MemberRepository memberRepository;
	
	@Autowired
	private MailSender mail; // 우리가 구현한 MailSender 의존성 주입 받기.
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public Member selectMemberById(String userId) {
		return memberRepository.selectMemberById(userId);
	}

	@Override
	public void authenicateEmail(Map<String, String> persistInfo) {
		mail.send(persistInfo.get("email"), "회원가입을 축하드립니다.", "<h1>회원가입 추카추카</h1>");
	}
	
	

}
