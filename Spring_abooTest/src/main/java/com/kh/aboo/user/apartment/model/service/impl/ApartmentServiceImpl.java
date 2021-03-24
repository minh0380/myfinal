package com.kh.aboo.user.apartment.model.service.impl;

import org.springframework.stereotype.Service;

import com.kh.aboo.user.apartment.model.repository.ApartmentRepository;
import com.kh.aboo.user.apartment.model.service.ApartmentService;
import com.kh.aboo.user.apartment.model.vo.Apartment;

@Service
public class ApartmentServiceImpl implements ApartmentService {
	
	private final ApartmentRepository apartmentRepository;
	
	public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
		this.apartmentRepository = apartmentRepository;
	}
	
	/**
	 * @author: MinHee
	 * @Date: 2021. 3. 24.
	 * @work:
	 */
	@Override
	public Apartment selectApartmentByIdx(String apartmentIdx) {
		return apartmentRepository.selectApartmentByIdx(apartmentIdx);
	}

}
