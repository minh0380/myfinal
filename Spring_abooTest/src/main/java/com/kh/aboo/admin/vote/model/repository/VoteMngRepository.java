package com.kh.aboo.admin.vote.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.aboo.admin.vote.model.vo.VoteMng;

@Mapper
public interface VoteMngRepository {
	
	@Insert("insert into tb_vote_mng(vote_no, apartment_idx, vote_begin_date, vote_end_date, vote_title, vote_content, vote_item) "
			+ "values(sc_vote_mng_idx.nextval, #{apartmentIdx}, #{voteBeginDate}, #{voteEndDate}, #{voteTitle}, #{voteContent}, #{voteItem})")
	int insertVoteMng(VoteMng voteMng);
	
	List<VoteMng> selectVoteMngList(@Param(value = "queryStart") int queryStart, @Param(value = "queryEnd") int queryEnd, @Param(value = "apartmentIdx") String apartmentIdx);
	
	@Select("select count(*) from tb_vote_mng where apartment_idx = #{apartmentIdx}")
	int selectVoteMngCnt(@Param(value = "apartmentIdx") String apartmentIdx);
	
	@Select("select * from tb_vote_mng where vote_no = #{voteNo} and vote_is_del = 0")
	VoteMng selectVoteMngByIdx(@Param(value = "voteNo") String voteNo);
	
	@Update("update tb_vote_mng set vote_is_del = 1 where vote_no = #{voteNo}")
	int deleteVoteMng(@Param(value = "voteNo") String voteNo);
	
	@Update("update tb_vote_mng set vote_begin_date = #{voteBeginDate}, vote_end_date = #{voteEndDate}, vote_title = #{voteTitle}"
			+ ", vote_content = #{voteContent}, vote_item = #{voteItem} where vote_no = #{voteNo}")
	int updateVoteMng(VoteMng voteMng);
	
	@Update("update tb_vote_mng set vote_is_finish = 1 where vote_no = #{voteNo}")
	int updateVoteIsFinish(@Param(value = "voteNo") String voteNo);
	
	@Delete("delete from tb_vote_gen where vote_no = #{voteNo}")
	void deleteVoteGen(@Param(value = "voteNo") String voteNo);
	
}
