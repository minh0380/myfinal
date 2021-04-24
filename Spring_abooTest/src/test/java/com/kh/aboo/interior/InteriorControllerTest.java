package com.kh.aboo.interior;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.kh.aboo.board.interior.model.vo.IntCmt;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class InteriorControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void intCmtModify() throws Exception {
		IntCmt intCmt = new IntCmt();
		intCmt.setIntCmtNo("100020");
		intCmt.setIntCmtContent("목객체를 이용한 댓글 수정");
		
		this.mockMvc.perform(post("/board/interior/intcmtmodify")
				.param("intCmtNo", intCmt.getIntCmtNo())
				.param("intCmtContent", intCmt.getIntCmtContent()))
		.andDo(print());
	}
	
	@Test
	public void intCmtPrivate() throws Exception {
		this.mockMvc.perform(get("/board/interior/intcmtprivate?intCmtNo=100020"))
		.andDo(print());
	}
	
}
