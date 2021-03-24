package com.kh.aboo.user.admin.model.vo;

import java.sql.Date;

public class Admin {

	private String partnerIdx;
	private String apartmentIdx;
	private String id;
	private String password;
	private String name;
	private String email;
	private String tell;
	private Date birth;
	private String isDel;

	public Admin() {
	}

	public Admin(String partnerIdx, String apartmentIdx, String id, String password, String name, String email,
			String tell, Date birth, String isDel) {
		super();
		this.partnerIdx = partnerIdx;
		this.apartmentIdx = apartmentIdx;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tell = tell;
		this.birth = birth;
		this.isDel = isDel;
	}

	public String getPartnerIdx() {
		return partnerIdx;
	}

	public void setPartnerIdx(String partnerIdx) {
		this.partnerIdx = partnerIdx;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "Admin [partnerIdx=" + partnerIdx + ", apartmentIdx=" + apartmentIdx + ", id=" + id + ", password="
				+ password + ", name=" + name + ", email=" + email + ", tell=" + tell + ", birth=" + birth + ", isDel="
				+ isDel + "]";
	}

}
