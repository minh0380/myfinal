package com.kh.aboo.admin.vote.model.vo;

import java.sql.Date;

public class VoteMng {
	
	private String voteNo;
	private String apartmentIdx;
	private Date voteBeginDate;
	private Date voteEndDate;
	private String voteWriter;
	private String voteTitle;
	private String voteContent;
	private String voteItem;
	private int voteIsFinish;
	private int voteIsDel;
	
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
	
	public Date getVoteBeginDate() {
		return voteBeginDate;
	}
	
	public void setVoteBeginDate(Date voteBeginDate) {
		this.voteBeginDate = voteBeginDate;
	}
	
	public Date getVoteEndDate() {
		return voteEndDate;
	}
	
	public void setVoteEndDate(Date voteEndDate) {
		this.voteEndDate = voteEndDate;
	}
	
	public String getVoteWriter() {
		return voteWriter;
	}
	
	public void setVoteWriter(String voteWriter) {
		this.voteWriter = voteWriter;
	}
	
	public String getVoteTitle() {
		return voteTitle;
	}
	
	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}
	
	public String getVoteContent() {
		return voteContent;
	}
	
	public void setVoteContent(String voteContent) {
		this.voteContent = voteContent;
	}
	
	public String getVoteItem() {
		return voteItem;
	}
	
	public void setVoteItem(String voteItem) {
		this.voteItem = voteItem;
	}
	
	public int getVoteIsFinish() {
		return voteIsFinish;
	}
	
	public void setVoteIsFinish(int voteIsFinish) {
		this.voteIsFinish = voteIsFinish;
	}
	
	public int getVoteIsDel() {
		return voteIsDel;
	}
	
	public void setVoteIsDel(int voteIsDel) {
		this.voteIsDel = voteIsDel;
	}

	@Override
	public String toString() {
		return "VoteMng [voteNo=" + voteNo + ", apartmentIdx=" + apartmentIdx + ", voteBeginDate=" + voteBeginDate
				+ ", voteEndDate=" + voteEndDate + ", voteWriter=" + voteWriter + ", voteTitle=" + voteTitle
				+ ", voteContent=" + voteContent + ", voteItem=" + voteItem + ", voteIsFinish=" + voteIsFinish
				+ ", voteIsDel=" + voteIsDel + "]";
	}
	
}
