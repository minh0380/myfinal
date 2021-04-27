package com.kh.aboo.vote;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.sql.Date;
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

import com.kh.aboo.admin.vote.model.vo.VoteMng;
import com.kh.aboo.myapt.vote.model.vo.VoteGen;
import com.kh.aboo.user.manager.model.vo.Admin;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class VoteControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	//투표 생성
	@Test
	public void makeVoteImpl() throws Exception {
		List<String> titleList = new ArrayList<>();
		titleList.add("2대 부녀회장 선거");
		titleList.add("2대 회장 선거");
		titleList.add("2대 부회장 선거");
		titleList.add("[재투표] 주차장 공사 찬반 투표");
		titleList.add("[재투표] 놀이터 확장 공사 찬반 투표");
		titleList.add("[재투표] 건물 외벽 도색 투표");
		titleList.add("[재투표] 엘레베이터 점검 시간 투표");
		titleList.add("2대 관리소장 선거");
		titleList.add("[재투표] 경비원 충원 찬반 투표");
		
		for (int i = 0; i < 9; i++) {
			Admin admin = new Admin();
			admin.setApartmentIdx("100020");
			
			VoteMng voteMng = new VoteMng();
			voteMng.setVoteBeginDate(Date.valueOf("2021-04-2"+i));
			voteMng.setVoteEndDate(Date.valueOf("2021-05-0"+(i+1)));
			voteMng.setVoteTitle(titleList.get(i));
			voteMng.setVoteContent("<p><img alt=\"\" src=\"/resources/ckstorage/images/2020101302540_0.jpg\" /></p><p>안녕하세요 반포자이아파트 주민 여러분. 아파트의 발전을 위해 소중한 한표 부탁드립니다.</p>");
			voteMng.setVoteItem("찬성,반대,기권");
			
			this.mockMvc.perform(post("/admin/vote/makevoteimpl")
					.sessionAttr("admin", admin)
					.param("voteBeginDate", voteMng.getVoteBeginDate().toString())
					.param("voteEndDate", voteMng.getVoteEndDate().toString())
					.param("voteTitle", voteMng.getVoteTitle())
					.param("voteContent", voteMng.getVoteContent())
					.param("voteItem", voteMng.getVoteItem()))
			.andDo(print());
		}
	}
	
	//투표 삭제
	@Test
	public void voteDelete() throws Exception {
		this.mockMvc.perform(get("/admin/vote/votedelete?voteNo=100220"))
		.andDo(print());
	}
	
	//투표 수정
	@Test
	public void voteModifyImpl() throws Exception {
		VoteMng voteMng = new VoteMng();
		voteMng.setVoteNo("100220");
		voteMng.setVoteBeginDate(Date.valueOf("2021-04-26"));
		voteMng.setVoteEndDate(Date.valueOf("2021-05-10"));
		voteMng.setVoteTitle("[수정] 목객체를 이용한 투표 수정");
		voteMng.setVoteContent("<p>수정 되나요?</p>");
		voteMng.setVoteItem("투표를,수정,합니다");
		
		this.mockMvc.perform(post("/admin/vote/votemodifyimpl")
				.param("voteNo", voteMng.getVoteNo())
				.param("voteBeginDate", voteMng.getVoteBeginDate().toString())
				.param("voteEndDate", voteMng.getVoteEndDate().toString())
				.param("voteTitle", voteMng.getVoteTitle())
				.param("voteContent", voteMng.getVoteContent())
				.param("voteItem", voteMng.getVoteItem()))
		.andDo(print());
	}
	
	//투표 종료
	@Test
	public void voteFinish() throws Exception {
		this.mockMvc.perform(get("/admin/vote/votefinish?voteNo=100220"))
		.andDo(print());
	}
	
	//투표 참여
	@Test
	public void doVoteImpl() throws Exception {
		for (int i = 0; i < 20; i++) {
			String generationWonIdxToVote = "100480";
			String generationWonTellToVote = "01028906219";
			
			VoteGen voteGen = new VoteGen();
			voteGen.setGenerationIdx("100620");
			voteGen.setVoteNo("100248");
			voteGen.setVoteOnWhat("찬성");
			
			this.mockMvc.perform(post("/myapt/vote/dovoteimpl")
					.sessionAttr("generationWonIdxToVote", generationWonIdxToVote)
					.sessionAttr("generationWonTellToVote", generationWonTellToVote)
					.param("generationIdx", voteGen.getGenerationIdx())
					.param("voteNo", voteGen.getVoteNo())
					.param("voteOnWhat", voteGen.getVoteOnWhat()))
			.andDo(print());
		}
	}
	
}
