package com.kh.aboo.board.interior.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.aboo.board.interior.model.vo.InteriorBrd;
import com.kh.aboo.common.util.paging.Paging;

@Mapper
public interface InteriorBrdRepository {
	
	@Insert("insert into tb_interior_brd(int_post_no, apartment_idx, int_title, int_thumbnail, int_content, int_writer, generation_idx) "
			+ "values(sc_interior_brd_idx.nextval, #{apartmentIdx}, #{intTitle}, #{intThumbnail}, #{intContent}, #{intWriter}, #{generationIdx})")
	int insertInteriorBrd(InteriorBrd interiorBrd);
	
	@Select("select * from tb_interior_brd where int_post_no = #{intPostNo} and int_is_del = 0")
	InteriorBrd selectInteriorBrdByIdx(String intPostNo);
	
	List<InteriorBrd> selectInteriorBrdList(@Param(value = "queryStart") int queryStart, @Param(value = "queryEnd") int queryEnd, @Param(value = "apartmentIdx") String apartmentIdx);
	
	@Select("select count(*) from tb_interior_brd where apartment_idx = #{apartmentIdx}")
	int selectInteriorBrdCnt(@Param(value = "apartmentIdx") String apartmentIdx);
	
	@Update("update tb_interior_brd set int_is_del = 1 where int_post_no = #{intPostNo} "
			+ "and apartment_idx = #{apartmentIdx}")
	int deleteInteriorBrd(@Param(value = "intPostNo") String intPostNo, @Param(value = "apartmentIdx") String apartmentIdx);
	
	@Update("update tb_interior_brd set int_title = #{intTitle}, int_thumbnail = #{intThumbnail}, int_content = #{intContent} where int_post_no = #{intPostNo}")
	int updateInteriorBrd(InteriorBrd interiorBrd);
	
	@Update("update tb_interior_brd set int_is_private = 1 where int_post_no = #{intPostNo}")
	int updateIntIsPrivate(@Param(value = "intPostNo") String intPostNo);
	
}
