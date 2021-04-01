package com.kh.aboo.bdmin.model.vo;

public class Bdmin {

	private String bdminIdx;
	private String id;
	private String password;
	private int isDel;

	public String getBdminIdx() {
		return bdminIdx;
	}

	public void setBdminIdx(String bdminIdx) {
		this.bdminIdx = bdminIdx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "Bdmin [bdminIdx=" + bdminIdx + ", id=" + id + ", password=" + password + ", isDel=" + isDel + "]";
	}

}
