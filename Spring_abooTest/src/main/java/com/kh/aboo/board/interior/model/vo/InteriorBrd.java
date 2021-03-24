package com.kh.aboo.board.interior.model.vo;

import java.sql.Date;

public class InteriorBrd {
	
	private String intPostNo;
	private String apartmentIdx;
	private String intTitle;
	private String intFile;
	private String intContent;
	private String intWriter;
	private Date intRegDate;
	private int intIsDel;
	private int intIsPrivate;
	
	public String getIntPostNo() {
		return intPostNo;
	}
	
	public void setIntPostNo(String intPostNo) {
		this.intPostNo = intPostNo;
	}
	
	public String getApartmentIdx() {
		return apartmentIdx;
	}
	
	public void setApartmentIdx(String apartmentIdx) {
		this.apartmentIdx = apartmentIdx;
	}
	
	public String getIntTitle() {
		return intTitle;
	}
	
	public void setIntTitle(String intTitle) {
		this.intTitle = intTitle;
	}
	
	public String getIntFile() {
		return intFile;
	}
	
	public void setIntFile(String intFile) {
		this.intFile = intFile;
	}
	
	public String getIntContent() {
		return intContent;
	}
	
	public void setIntContent(String intContent) {
		this.intContent = intContent;
	}
	
	public String getIntWriter() {
		return intWriter;
	}
	
	public void setIntWriter(String intWriter) {
		this.intWriter = intWriter;
	}
	
	public Date getIntRegDate() {
		return intRegDate;
	}
	
	public void setIntRegDate(Date intRegDate) {
		this.intRegDate = intRegDate;
	}
	
	public int getIntIsDel() {
		return intIsDel;
	}
	
	public void setIntIsDel(int intIsDel) {
		this.intIsDel = intIsDel;
	}
	
	public int getIntIsPrivate() {
		return intIsPrivate;
	}
	
	public void setIntIsPrivate(int intIsPrivate) {
		this.intIsPrivate = intIsPrivate;
	}

	@Override
	public String toString() {
		return "InteriorBrd [intPostNo=" + intPostNo + ", apartmentIdx=" + apartmentIdx + ", intTitle=" + intTitle
				+ ", intFile=" + intFile + ", intContent=" + intContent + ", intWriter=" + intWriter + ", intRegDate="
				+ intRegDate + ", intIsDel=" + intIsDel + ", intIsPrivate=" + intIsPrivate + "]";
	}
	
}
