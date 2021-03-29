package com.kh.aboo.admin.vote.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.admin.vote.model.vo.VoteMng;

@Mapper
public interface VoteMngRepository {
	
	@Insert("insert into tb_vote_mng(vote_no, apartment_idx, vote_begin_date, vote_end_date, vote_title, vote_content, vote_item) "
			+ "values(sc_vote_mng_idx.nextval, #{apartmentIdx}, #{voteBeginDate}, #{voteEndDate}, #{voteTitle}, #{voteContent}, #{voteItem})")
	int insertVoteMng(VoteMng voteMng);
	
	List<VoteMng> selectVoteMngList(@Param(value = "queryStart") int queryStart, @Param(value = "queryEnd") int queryEnd, @Param(value = "apartmentIdx") String apartmentIdx);
	
	@Select("select count(*) from tb_vote_mng where apartment_idx = #{apartmentIdx}")
	int selectVoteMngCnt(@Param(value = "apartmentIdx") String apartmentIdx);
	
}
