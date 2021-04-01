package com.kh.aboo.bdmin.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private String nNo;
	private String nTitle;
	private String nContent;
	private String nWriter;
	private Date nRegDate;
	private int nIsDel;
	
	public String getnNo() {
		return nNo;
	}
	
	public void setnNo(String nNo) {
		this.nNo = nNo;
	}
	
	public String getnTitle() {
		return nTitle;
	}
	
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	
	public String getnContent() {
		return nContent;
	}
	
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	
	public String getnWriter() {
		return nWriter;
	}
	
	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}
	
	public Date getnRegDate() {
		return nRegDate;
	}
	
	public void setnRegDate(Date nRegDate) {
		this.nRegDate = nRegDate;
	}
	
	public int getnIsDel() {
		return nIsDel;
	}
	
	public void setnIsDel(int nIsDel) {
		this.nIsDel = nIsDel;
	}

	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nWriter=" + nWriter
				+ ", nRegDate=" + nRegDate + ", nIsDel=" + nIsDel + "]";
	}
	
}
