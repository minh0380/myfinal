package com.kh.aboo.myapt.vote.model.vo;

public class VoteGen {
	
	private String voteDetailNo;
	private String generationIdx;
	private String voteNo;
	private String generationWonIdx;
	private String voteGenwonTell;
	private String voteOnWhat;
	
	public String getVoteDetailNo() {
		return voteDetailNo;
	}
	
	public void setVoteDetailNo(String voteDetailNo) {
		this.voteDetailNo = voteDetailNo;
	}
	
	public String getGenerationIdx() {
		return generationIdx;
	}
	
	public void setGenerationIdx(String generationIdx) {
		this.generationIdx = generationIdx;
	}
	
	public String getVoteNo() {
		return voteNo;
	}
	
	public void setVoteNo(String voteNo) {
		this.voteNo = voteNo;
	}
	
	public String getGenerationWonIdx() {
		return generationWonIdx;
	}
	
	public void setGenerationWonIdx(String generationWonIdx) {
		this.generationWonIdx = generationWonIdx;
	}
	
	public String getVoteGenwonTell() {
		return voteGenwonTell;
	}
	
	public void setVoteGenwonTell(String voteGenwonTell) {
		this.voteGenwonTell = voteGenwonTell;
	}
	
	public String getVoteOnWhat() {
		return voteOnWhat;
	}
	
	public void setVoteOnWhat(String voteOnWhat) {
		this.voteOnWhat = voteOnWhat;
	}

	@Override
	public String toString() {
		return "VoteGen [voteDetailNo=" + voteDetailNo + ", generationIdx=" + generationIdx + ", voteNo=" + voteNo
				+ ", generationWonIdx=" + generationWonIdx + ", voteGenwonTell=" + voteGenwonTell + ", voteOnWhat="
				+ voteOnWhat + "]";
	}
	
}
