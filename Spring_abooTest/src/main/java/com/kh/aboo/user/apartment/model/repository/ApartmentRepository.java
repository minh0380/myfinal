package com.kh.aboo.user.apartment.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.user.apartment.model.vo.Apartment;

@Mapper
public interface ApartmentRepository {
	
	/**
	 * @author: MinHee
	 * @Date: 2021. 3. 24.
	 * @work: selectApartmentByIdx
	 */
	@Select("select * from tb_apartment where apartment_idx = #{apartmentIdx}")
	Apartment selectApartmentByIdx(@Param(value = "apartmentIdx") String apartmentIdx);
	
}
