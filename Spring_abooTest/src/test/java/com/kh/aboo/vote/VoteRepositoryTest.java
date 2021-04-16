package com.kh.aboo.vote;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.aboo.admin.vote.model.repository.VoteMngRepository;
import com.kh.aboo.admin.vote.model.vo.VoteMng;
import com.kh.aboo.myapt.vote.model.repository.VoteRepository;
import com.kh.aboo.myapt.vote.model.vo.VoteGen;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class VoteRepositoryTest {
	
	@Autowired
	VoteMngRepository voteMngRepository;
	@Autowired
	VoteRepository voteRepository;
	
	@Test
	public void insertVoteMng() {
		VoteMng voteMng = new VoteMng();
		voteMng.setApartmentIdx("100000");
		voteMng.setVoteBeginDate(Date.valueOf("2021-04-15"));
		voteMng.setVoteEndDate(Date.valueOf("2021-05-01"));
		voteMng.setVoteTitle("투표만들기테스트");
		voteMng.setVoteContent("<p>투표 테스트로 만들기</p>");
		voteMng.setVoteItem("테스트로,만든,투표,입니다");
		System.out.println(voteMngRepository.insertVoteMng(voteMng));
	}
	
	@Test
	public void insertVoteGen() {
		VoteGen voteGen = new VoteGen();
		voteGen.setGenerationIdx("100522");
		voteGen.setVoteNo("100180");
		voteGen.setGenerationWonIdx("100340");
		voteGen.setVoteGenwonTell("01011111111");
		voteGen.setVoteOnWhat("테스트로");
		System.out.println(voteRepository.insertVoteGen(voteGen));
	}
	
}
