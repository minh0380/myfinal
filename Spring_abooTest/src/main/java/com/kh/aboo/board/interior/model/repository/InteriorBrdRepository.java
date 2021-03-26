package com.kh.aboo.board.interior.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.board.interior.model.vo.InteriorBrd;
import com.kh.aboo.common.util.paging.Paging;

@Mapper
public interface InteriorBrdRepository {
	
	@Insert("insert into tb_interior_brd(int_post_no, apartment_idx, int_title, int_thumbnail, int_content, int_writer) "
			+ "values(sc_interior_brd_idx.nextval, #{apartmentIdx}, #{intTitle}, #{intThumbnail}, #{intContent}, #{intWriter})")
	int insertInteriorBrd(InteriorBrd interiorBrd);
	
	@Select("select * from tb_interior_brd where int_post_no = #{intPostNo} and int_is_del = 0")
	InteriorBrd selectInteriorBrdByIdx(String intPostNo);
	
	List<InteriorBrd> selectInteriorBrdList(Paging paging);
	
	@Select("select count(*) from tb_interior_brd")
	int selectInteriorBrdCnt();
	
}
