package com.kh.aboo.board.info.model.vo;

import java.sql.Date;

public class InfoBoard {
	
	private String bIdx;
	private String apartmentIdx;
	private String bCategory;
	private String bTitle;
	private String bContent;
	private Date bWdate;
	private String bWriter;
	private int bAns;
	private int bIsDel;
	private int bIsPrivate;
	private String generationIdx;
	
	public InfoBoard() {
		
	}
	
	public InfoBoard(String bIdx, String apartmentIdx, String bCategory, String bTitle, String bContent, Date bWdate,
			String bWriter, int bAns, int bIsDel, int bIsPrivate) {
		super();
		this.bIdx = bIdx;
		this.apartmentIdx = apartmentIdx;
		this.bCategory = bCategory;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWdate = bWdate;
		this.bWriter = bWriter;
		this.bAns = bAns;
		this.bIsDel = bIsDel;
		this.bIsPrivate = bIsPrivate;
	}

	public String getbIdx() {
		return bIdx;
	}

	public void setbIdx(String bIdx) {
		this.bIdx = bIdx;
	}

	public String getApartmentIdx() {
		return apartmentIdx;
	}

	public void setApartmentIdx(String apartmentIdx) {
		this.apartmentIdx = apartmentIdx;
	}

	public String getbCategory() {
		return bCategory;
	}

	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Date getbWdate() {
		return bWdate;
	}

	public void setbWdate(Date bWdate) {
		this.bWdate = bWdate;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public int getbAns() {
		return bAns;
	}

	public void setbAns(int bAns) {
		this.bAns = bAns;
	}

	public int getbIsDel() {
		return bIsDel;
	}

	public void setbIsDel(int bIsDel) {
		this.bIsDel = bIsDel;
	}

	public int getbIsPrivate() {
		return bIsPrivate;
	}

	public void setbIsPrivate(int bIsPrivate) {
		this.bIsPrivate = bIsPrivate;
	}

	public String getGenerationIdx() {
		return generationIdx;
	}

	public void setGenerationIdx(String generationIdx) {
		this.generationIdx = generationIdx;
	}

	@Override
	public String toString() {
		return "InfoBoard [bIdx=" + bIdx + ", apartmentIdx=" + apartmentIdx + ", bCategory=" + bCategory + ", bTitle="
				+ bTitle + ", bContent=" + bContent + ", bWdate=" + bWdate + ", bWriter=" + bWriter + ", bAns=" + bAns
				+ ", bIsDel=" + bIsDel + ", bIsPrivate=" + bIsPrivate + ", generationIdx=" + generationIdx + "]";
	}


}
