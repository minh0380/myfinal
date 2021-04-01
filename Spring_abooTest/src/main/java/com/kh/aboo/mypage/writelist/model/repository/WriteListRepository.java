package com.kh.aboo.mypage.writelist.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.board.info.model.vo.InfoBoard;
import com.kh.aboo.board.interior.model.vo.InteriorBrd;
import com.kh.aboo.board.used.model.vo.UsedBrd;

@Mapper
public interface WriteListRepository {
	
	List<InteriorBrd> selectMyInteriorBrdList(@Param(value = "queryStart") int queryStart, @Param(value = "queryEnd") int queryEnd, @Param(value = "apartmentIdx") String apartmentIdx, @Param(value = "generationIdx") String generationIdx);
	
	@Select("select count(*) from tb_interior_brd where apartment_idx = #{apartmentIdx} and int_is_del = 0 and generation_idx = #{generationIdx}")
	int selectMyInteriorBrdCnt(@Param(value = "apartmentIdx") String apartmentIdx, @Param(value = "generationIdx") String generationIdx);
	
	List<UsedBrd> selectMyUsedBrdList(@Param(value = "queryStart") int queryStart, @Param(value = "queryEnd") int queryEnd, @Param(value = "apartmentIdx") String apartmentIdx, @Param(value = "generationIdx") String generationIdx);
	
	@Select("select count(*) from tb_used_brd where apartment_idx = #{apartmentIdx} and is_del = 0 and generation_idx = #{generationIdx}")
	int selectMyUsedBrdCnt(@Param(value = "apartmentIdx") String apartmentIdx, @Param(value = "generationIdx") String generationIdx);
	
	List<InfoBoard> selectMyInfoBrdList(@Param(value = "queryStart") int queryStart, @Param(value = "queryEnd") int queryEnd, @Param(value = "apartmentIdx") String apartmentIdx, @Param(value = "generationIdx") String generationIdx);
	
	@Select("select count(*) from tb_inf_qst_brd where apartment_idx = #{apartmentIdx} and b_isdel = 0 and generation_idx = #{generationIdx}")
	int selectMyInfoBrdCnt(@Param(value = "apartmentIdx") String apartmentIdx, @Param(value = "generationIdx") String generationIdx);
	
}
