package com.kh.aboo.admin.vote.model.service;

import java.util.Map;

import com.kh.aboo.admin.vote.model.vo.VoteMng;

public interface AdminVoteService {
	
	int insertVoteMng(VoteMng voteMng);
	Map<String, Object> selectVoteMngList(int currentPage, String apartmentIdx);
	
}
