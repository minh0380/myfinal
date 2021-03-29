package com.kh.aboo.admin.vote.model.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.aboo.admin.vote.model.repository.VoteMngRepository;
import com.kh.aboo.admin.vote.model.service.AdminVoteService;
import com.kh.aboo.admin.vote.model.vo.VoteMng;
import com.kh.aboo.common.util.paging.Paging;

@Service
public class AdminVoteServiceImpl implements AdminVoteService {
	
	private final VoteMngRepository voteMngRepository;
	
	public AdminVoteServiceImpl(VoteMngRepository voteMngRepository) {
		this.voteMngRepository = voteMngRepository;
	}
	
	@Override
	public int insertVoteMng(VoteMng voteMng) {
		return voteMngRepository.insertVoteMng(voteMng);
	}

	@Override
	public Map<String, Object> selectVoteMngList(int currentPage, String apartmentIdx) {
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("vote")
				.total(voteMngRepository.selectVoteMngCnt(apartmentIdx))
				.build();
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("paging", paging);
		commandMap.put("voteMng", voteMngRepository.selectVoteMngList(paging.getQueryStart(), paging.getQueryEnd(), apartmentIdx));
		
		return commandMap;
	}
	
}