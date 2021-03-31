package com.kh.aboo.admin.vote.model.service;

import java.util.Map;

import com.kh.aboo.admin.vote.model.vo.VoteMng;

public interface AdminVoteService {
	
	int insertVoteMng(VoteMng voteMng);
	Map<String, Object> selectVoteMngList(int currentPage, String apartmentIdx);
	VoteMng selectVoteMngByIdx(String voteNo);
	int deleteVoteMng(String voteNo);
	int updateVoteMng(VoteMng voteMng);
	int updateVoteIsFinish(String voteNo);
	void deleteVoteGen(String voteNo);
	Map<String, Object> selectVoteMngSearchList(int currentPage, String apartmentIdx, String voteSearch);
	
}
