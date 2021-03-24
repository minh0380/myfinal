package com.kh.aboo.user.generation.model.vo;

import java.sql.Date;

public class Generation {
	private String generationIdx;
	private String apartmentIdx;
	private String id;
	private String password;
	private String tell;
	private Date regDate;
	private String email;
	private String building;
	private String num;

	public Generation() {
	}

	public Generation(String generationIdx, String apartmentIdx, String id, String password, String tell, Date regDate,
			String email, String building, String num) {
		super();
		this.generationIdx = generationIdx;
		this.apartmentIdx = apartmentIdx;
		this.id = id;
		this.password = password;
		this.tell = tell;
		this.regDate = regDate;
		this.email = email;
		this.building = building;
		this.num = num;
	}

	public String getGenerationIdx() {
		return generationIdx;
	}

	public void setGenerationIdx(String generationIdx) {
		this.generationIdx = generationIdx;
	}

	public String getApartmentIdx() {
		return apartmentIdx;
	}

	public void setApartmentIdx(String apartmentIdx) {
		this.apartmentIdx = apartmentIdx;
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

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Generation [generationIdx=" + generationIdx + ", apartmentIdx=" + apartmentIdx + ", id=" + id
				+ ", password=" + password + ", tell=" + tell + ", regDate=" + regDate + ", email=" + email
				+ ", building=" + building + ", num=" + num + "]";
	}

}
