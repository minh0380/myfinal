package com.kh.aboo.interior;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

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
import com.kh.aboo.board.interior.model.vo.InteriorBrd;
import com.kh.aboo.user.generation.model.vo.Generation;

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
	
	//게시글 작성
	@Test
	public void intUploadImpl() throws Exception {
		List<String> imgList = new ArrayList<>();
		imgList.add("2c50d91a-d571-41fa-b8f0-3c15e9981df0.jpg");
		imgList.add("37d97ed9d875be37abef71ba09e45b4c.jpg");
		imgList.add("663e6fafc9251123be750b25af811ad9.jpg");
		imgList.add("ddfeeb868e230277cab4b9462d6fad0b.jpg");
		imgList.add("unnamed.png");
		imgList.add("거실-러그.png");
		imgList.add("11.jpeg");
		imgList.add("1556026258_W1xvxcW.jpeg");
		imgList.add("ed9584eba6bdec8aa4_led_eb8db0ecbd94_ed9584eb9dbceba998ed8ab8_eca084eab5ac_6.jpg");
		imgList.add("49497-6.jpg");
		
		for (int i = 0; i < 10; i++) {
			Generation generation = new Generation();
			generation.setApartmentIdx("100020");
			generation.setBuilding("101");
			generation.setNum("102");
			generation.setGenerationIdx("100581");
			
			InteriorBrd interiorBrd = new InteriorBrd();
			interiorBrd.setIntTitle("오늘의 나의 집 이렇게 꾸며보아요 " + (i+1) + "탄");
			interiorBrd.setIntContent("<p><img alt=\"\" src=\"/resources/ckstorage/images/"+ imgList.get(i) +"\" /></p><p>구글에서 주워온 사진들 입니당</p>");
			
			this.mockMvc.perform(post("/board/interior/intuploadimpl")
					.sessionAttr("generation", generation)
					.param("intTitle", interiorBrd.getIntTitle())
					.param("intContent", interiorBrd.getIntContent()))
			.andDo(print());
		}
	}
	
	//게시글 수정
	@Test
	public void intModifyImpl() throws Exception {
		InteriorBrd interiorBrd = new InteriorBrd();
		interiorBrd.setIntTitle("목객체를 이용한 게시판 수정");
		interiorBrd.setIntContent("<p>게시판 수정</p>");
		
		this.mockMvc.perform(post("/board/interior/intmodifyimpl?intPostNo=100280")
				.param("intTitle", interiorBrd.getIntTitle())
				.param("intContent", interiorBrd.getIntContent()))
		.andDo(print());
	}
	
	//게시글 삭제
	@Test
	public void intDelete() throws Exception {
		Generation generation = new Generation();
		generation.setApartmentIdx("100000");
		
		this.mockMvc.perform(get("/board/interior/intdelete?intPostNo=100050")
				.sessionAttr("generation", generation))
		.andDo(print());
	}
	
	//게시글 비공개 처리
	@Test
	public void intPrivate() throws Exception {
		this.mockMvc.perform(get("/board/interior/intprivate?intPostNo=100050"))
		.andDo(print());
	}
	
	//댓글 작성
	@Test
	public void intCmtUpload() throws Exception {
		for (int i = 0; i < 9; i++) {
			Generation generation = new Generation();
			generation.setBuilding("101");
			generation.setNum("1002");
			
			IntCmt intCmt = new IntCmt();
			intCmt.setIntPostNo("10037" + i);
			intCmt.setIntCmtContent("감사합니다~~!");
			intCmt.setGenerationIdx("100902");
			
			this.mockMvc.perform(post("/board/interior/intcmtupload")
					.sessionAttr("generation", generation)
					.param("intPostNo", intCmt.getIntPostNo())
					.param("intCmtContent", intCmt.getIntCmtContent())
					.param("generationIdx", intCmt.getGenerationIdx()))
			.andDo(print());
		}
	}
	
	//댓글 삭제
	@Test
	public void intCmtDelete() throws Exception {
		this.mockMvc.perform(get("/board/interior/intcmtdelete?intCmtNo=100020"))
		.andDo(print());
	}
	
	//댓글 수정
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
	
	//댓글 비공개 처리
	@Test
	public void intCmtPrivate() throws Exception {
		this.mockMvc.perform(get("/board/interior/intcmtprivate?intCmtNo=100020"))
		.andDo(print());
	}
	
}
