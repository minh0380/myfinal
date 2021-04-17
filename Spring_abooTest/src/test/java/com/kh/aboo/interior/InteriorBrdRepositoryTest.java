package com.kh.aboo.interior;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.aboo.board.interior.model.repository.InteriorBrdRepository;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class InteriorBrdRepositoryTest {
	
	@Autowired
	InteriorBrdRepository interiorBrdRepository;
	
	@Test
	public void insertInteriorBrd() {
		InteriorBrd interiorBrd = new InteriorBrd();
		interiorBrd.setApartmentIdx("100000");
		interiorBrd.setIntTitle("테스트를 사용한 인테리어 게시글");
		interiorBrd.setIntThumbnail("../../../resources/abooimg/nopreviewimg.jpg");
		interiorBrd.setIntContent("<p>테스트</p>");
		interiorBrd.setIntWriter("108동 805호");
		interiorBrd.setIntRegDate(Date.valueOf("2021-04-17"));
		interiorBrd.setGenerationIdx("100328");
		System.out.println(interiorBrdRepository.insertInteriorBrd(interiorBrd));
		
	}
	
}
