package com.kh.aboo.myapt.vote.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.myapt.vote.model.vo.AuthToVote;
import com.kh.aboo.myapt.vote.model.vo.VoteGen;

@Mapper
public interface VoteRepository {
	
	@Select("select count(*) from tb_generation_won gw "
			+ "inner join tb_generation g using(generation_idx) "
			+ "where g.apartment_idx = #{apartmentIdx} and g.building = #{building} and g.num = #{num} "
			+ "and gw.name = #{name} and gw.tell = #{tell}")
	int selectGenerationWonToAuth(AuthToVote authToVote);
	
	@Select("select generation_won_idx from tb_generation_won gw "
			+ "inner join tb_generation g using(generation_idx) "
			+ "where g.apartment_idx = #{apartmentIdx} and g.building = #{building} and g.num = #{num} "
			+ "and gw.name = #{name} and gw.tell = #{tell}")
	String selectGenerationWonIdxToVote(AuthToVote authToVote);
	
	@Select("select gw.tell from tb_generation_won gw "
			+ "inner join tb_generation g using(generation_idx) "
			+ "where g.apartment_idx = #{apartmentIdx} and g.building = #{building} and g.num = #{num} "
			+ "and gw.name = #{name} and gw.tell = #{tell}")
	String selectGenerationWonTellToVote(AuthToVote authToVote);
	
	@Insert("insert into tb_vote_gen(vote_detail_no, generation_idx, vote_no, generation_won_idx, vote_genwon_tell, vote_on_what) "
			+ "values(sc_vote_gen_idx.nextval, #{generationIdx}, #{voteNo}, #{generationWonIdx}, #{voteGenwonTell}, #{voteOnWhat})")
	int insertVoteGen(VoteGen voteGen);
	
	@Select("select count(*) from tb_vote_gen where generation_idx = #{generationIdx} and vote_no = #{voteNo}")
	int selectIfParticipate(@Param(value = "generationIdx") String generationIdx, @Param(value = "voteNo") String voteNo);
	
}
