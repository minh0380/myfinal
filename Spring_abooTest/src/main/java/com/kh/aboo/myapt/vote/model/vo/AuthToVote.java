package com.kh.aboo.myapt.vote.model.vo;

public class AuthToVote {
	
	private String voteNo;
	private String apartmentIdx;
	private String building;
	private String num;
	private String name;
	private String tell;
	
	public String getVoteNo() {
		return voteNo;
	}
	
	public void setVoteNo(String voteNo) {
		this.voteNo = voteNo;
	}
	
	public String getApartmentIdx() {
		return apartmentIdx;
	}
	
	public void setApartmentIdx(String apartmentIdx) {
		this.apartmentIdx = apartmentIdx;
	}
	
	public String getBuilding() {
		return building;
	}
	
	public void setBuilding(String building) {
		this.building = building;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTell() {
		return tell;
	}
	
	public void setTell(String tell) {
		this.tell = tell;
	}

	@Override
	public String toString() {
		return "AuthToVote [voteNo=" + voteNo + ", apartmentIdx=" + apartmentIdx + ", building=" + building + ", num="
				+ num + ", name=" + name + ", tell=" + tell + "]";
	}
	
}
