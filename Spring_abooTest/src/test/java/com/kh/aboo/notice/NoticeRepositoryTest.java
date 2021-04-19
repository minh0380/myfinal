package com.kh.aboo.notice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.aboo.bdmin.notice.model.repository.NoticeRepository;
import com.kh.aboo.bdmin.notice.model.vo.Notice;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class NoticeRepositoryTest {
	
	@Autowired
	NoticeRepository noticeRepository;
	
	@Test
	public void insertNotice() {
		Notice notice = new Notice();
		notice.setnTitle("테스트를 이용해 만든 공지사항입니다.");
		notice.setnContent("테스트용 공지사항");
		System.out.println(noticeRepository.insertNotice(notice));
	}
	
}
