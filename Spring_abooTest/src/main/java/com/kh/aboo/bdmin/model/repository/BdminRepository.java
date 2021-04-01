package com.kh.aboo.bdmin.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.bdmin.model.vo.Bdmin;
import com.kh.aboo.user.apartment.model.vo.Apartment;

@Mapper
public interface BdminRepository {
	
	// [로그인]
	@Select("select * from tb_bdmin where id = #{id} and is_del = 0")
	Bdmin selectBdminForAuth(Bdmin bdmin);
	
	// [아파트 목록]
	// 1. 페이징 위한 개수 확인
	int selectContentCnt();
	
	// 2. 페이징 화면 구현을 위한 list
	List<Apartment> selectApartrList();


}
