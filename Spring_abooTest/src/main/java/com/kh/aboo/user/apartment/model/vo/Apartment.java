package com.kh.aboo.user.apartment.model.vo;

public class Apartment {
	
	private String apartmentIdx;
	private String apartmentName;
	private String apartmentAddress;
	private String apartmentLat;
	private String apartmentLng;
	
	public String getApartmentIdx() {
		return apartmentIdx;
	}
	
	public void setApartmentIdx(String apartmentIdx) {
		this.apartmentIdx = apartmentIdx;
	}
	
	public String getApartmentName() {
		return apartmentName;
	}
	
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	
	public String getApartmentAddress() {
		return apartmentAddress;
	}
	
	public void setApartmentAddress(String apartmentAddress) {
		this.apartmentAddress = apartmentAddress;
	}
	
	public String getApartmentLat() {
		return apartmentLat;
	}
	
	public void setApartmentLat(String apartmentLat) {
		this.apartmentLat = apartmentLat;
	}
	
	public String getApartmentLng() {
		return apartmentLng;
	}
	
	public void setApartmentLng(String apartmentLng) {
		this.apartmentLng = apartmentLng;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentIdx=" + apartmentIdx + ", apartmentName=" + apartmentName + ", apartmentAddress="
				+ apartmentAddress + ", apartmentLat=" + apartmentLat + ", apartmentLng=" + apartmentLng + "]";
	}
	
}
