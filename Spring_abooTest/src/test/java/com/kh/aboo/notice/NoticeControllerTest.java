package com.kh.aboo.notice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kh.aboo.bdmin.model.vo.Bdmin;
import com.kh.aboo.bdmin.notice.model.vo.Notice;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class NoticeControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	//공지사항 작성
	@Test
	public void noticeUploadImpl() throws Exception {
		for (int i = 0; i < 10; i++) {
			Bdmin bdmin = new Bdmin();
			
			Notice notice = new Notice();
			notice.setnTitle((i+1) + "차 기능 업데이트");
			notice.setnContent("<p><img alt=\"\" src=\"/resources/ckstorage/images/KakaoTalk_20210310_093003411_01.png\" /></p><p>아파트를 부탁해에서 알려드립니다. 게시판 기능 중 게시판의 성격과 관계 없는 글을 관리자가 비공개 시킬 수 있는 기능이 추가되었습니다. 이점 참고 바랍니다.</p><p>아파트를 부탁해를 이용해주시는 고객님께 감사드립니다.</p>");
			
			this.mockMvc.perform(post("/bdmin/notice/noticeuploadimpl")
					.sessionAttr("bdmin", bdmin)
					.param("nTitle", notice.getnTitle())
					.param("nContent", notice.getnContent()))
			.andDo(print());
		}
	}
	
}
