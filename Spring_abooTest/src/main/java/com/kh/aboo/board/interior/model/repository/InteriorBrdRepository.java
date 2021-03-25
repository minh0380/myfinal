package com.kh.aboo.board.interior.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.board.interior.model.vo.InteriorBrd;

@Mapper
public interface InteriorBrdRepository {
	
	@Insert("insert into tb_interior_brd(int_post_no, apartment_idx, int_title, int_content, int_writer) "
			+ "values(sc_interior_brd_idx.nextval, #{apartmentIdx}, #{intTitle}, #{intContent}, #{intWriter})")
	int insertInteriorBrd(InteriorBrd interiorBrd);
	
	@Select("select * from tb_interior_brd where int_post_no = #{intPostNo}")
	InteriorBrd selectInteriorBrdByIdx(String intPostNo);
	
}
