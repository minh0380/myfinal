package com.kh.aboo.interior;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.aboo.board.interior.model.repository.IntCmtRepository;
import com.kh.aboo.board.interior.model.vo.IntCmt;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class IntCmtRepositoryTest {
	
	@Autowired
	IntCmtRepository intCmtRepository;
	
	@Test
	public void insertIntCmt() {
		IntCmt intCmt = new IntCmt();
		intCmt.setIntPostNo("100240");
		intCmt.setIntCmtContent("테스트를 사용한 댓글");
		intCmt.setIntCmtWriter("105동 503호");
		intCmt.setGenerationIdx("100308");
		System.out.println(intCmtRepository.insertIntCmt(intCmt));
	}
	
}
