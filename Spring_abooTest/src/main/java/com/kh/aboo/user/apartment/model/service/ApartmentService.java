package com.kh.aboo.user.apartment.model.service;

import com.kh.aboo.user.apartment.model.vo.Apartment;

public interface ApartmentService {
	
	/**
	 * @author: MinHee
	 * @Date: 2021. 3. 24.
	 * @work: selectApartmentByIdx
	 */
	Apartment selectApartmentByIdx(String apartmentIdx);
	
}
