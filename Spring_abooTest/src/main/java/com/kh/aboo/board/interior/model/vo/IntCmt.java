package com.kh.aboo.board.interior.model.vo;

import java.sql.Date;

public class IntCmt {
	
	private String intCmtNo;
	private String intPostNo;
	private String intCmtContent;
	private String intCmtWriter;
	private Date intCmtRegDate;
	private int intCmtIsDel;
	private int intCmtIsPrivate;
	private String generationIdx;
	
	public String getIntCmtNo() {
		return intCmtNo;
	}
	
	public void setIntCmtNo(String intCmtNo) {
		this.intCmtNo = intCmtNo;
	}
	
	public String getIntPostNo() {
		return intPostNo;
	}
	
	public void setIntPostNo(String intPostNo) {
		this.intPostNo = intPostNo;
	}
	
	public String getIntCmtContent() {
		return intCmtContent;
	}
	
	public void setIntCmtContent(String intCmtContent) {
		this.intCmtContent = intCmtContent;
	}
	
	public String getIntCmtWriter() {
		return intCmtWriter;
	}
	
	public void setIntCmtWriter(String intCmtWriter) {
		this.intCmtWriter = intCmtWriter;
	}
	
	public Date getIntCmtRegDate() {
		return intCmtRegDate;
	}
	
	public void setIntCmtRegDate(Date intCmtRegDate) {
		this.intCmtRegDate = intCmtRegDate;
	}
	
	public int getIntCmtIsDel() {
		return intCmtIsDel;
	}
	
	public void setIntCmtIsDel(int intCmtIsDel) {
		this.intCmtIsDel = intCmtIsDel;
	}
	
	public int getIntCmtIsPrivate() {
		return intCmtIsPrivate;
	}
	
	public void setIntCmtIsPrivate(int intCmtIsPrivate) {
		this.intCmtIsPrivate = intCmtIsPrivate;
	}

	public String getGenerationIdx() {
		return generationIdx;
	}

	public void setGenerationIdx(String generationIdx) {
		this.generationIdx = generationIdx;
	}

	@Override
	public String toString() {
		return "IntCmt [intCmtNo=" + intCmtNo + ", intPostNo=" + intPostNo + ", intCmtContent=" + intCmtContent
				+ ", intCmtWriter=" + intCmtWriter + ", intCmtRegDate=" + intCmtRegDate + ", intCmtIsDel=" + intCmtIsDel
				+ ", intCmtIsPrivate=" + intCmtIsPrivate + ", generationIdx=" + generationIdx + "]";
	}
	
}
