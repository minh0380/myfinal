package com.kh.toy.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.vo.Member;


@WebAppConfiguration 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemberRepositoryTest {

	   @Autowired
	   MemberRepository memberRepository;// dao 주입 받아서 테스트한다.
	
	   @Test
	   public void selectMemberById() {
		   String userId="choayoung91"; 
		   Member member = memberRepository.selectMemberById(userId);//리터럴로 직접 넘기지말고 변수로 넘겨줄 것
		   System.out.println(member);
	   }
}
