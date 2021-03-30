package com.kh.aboo.user.generation.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.aboo.user.generation.model.vo.Generation;
import com.kh.aboo.user.generationWon.model.vo.GenerationWon;

@Mapper
public interface GenerationRepository {	
	
	@Select("select * from TB_GENERATION where ID = #{Id} and IS_DEL = 0")
	public Generation selectGenerationForAuth(String Id);
	
	@Insert("insert into TB_GENERATION(GENERATION_IDX,APARTMENT_IDX,ID,PASSWORD,BUILDING,NUM) values(SC_GENERATION_IDX.nextval,#{apartmentIdx},#{id},#{password},#{building},#{num})")
	public int insertGeneration(Generation generation);
	
	//아이디 메일보내기 전에 있는 세대인지 체크
	@Select("select * from TB_GENERATION where BUILDING = #{building} and NUM = #{num} and EMAIL = #{email}")
	public Generation selectFindId(Generation generation);
	
	//비밀번호 메일보내기 전에 있는 세대인지 체크
	@Select("select * from TB_GENERATION where email = #{email} and id = #{id}")
	public Generation selectFindPassword(Generation generation);
	
	//비밀번호 변경
	@Update("update TB_GENERATION set PASSWORD = #{password} where ID = #{id}")
	public int updateFindPassword(Generation generation);
		
	//세대원 추가 페이지 리스트
	List<GenerationWon> selectGenerationWonList(Map<String,Object> generationMap);

	//세대 총 수
	@Select("select count(*) from TB_GENERATION_WON where IS_DEL = 0 and GENERATION_IDX = #{generationIdx}")
	int selectContentCnt(String generationIdx);

	//세대원 수정
	@Update("update TB_GENERATION_WON set NAME = #{name} , tell = #{tell} where generation_won_idx = #{generationWonIdx}")
	int updateGenerationWonModify(GenerationWon generationWon);
	
	//세대원 삭제
	@Update("update TB_GENERATION_WON set is_del = 1 where generation_won_idx = #{generationWonIdx}")
	int updateGenerationWonDelete(GenerationWon generationWon);
	
	//세대원 추가
	@Insert("insert into TB_GENERATION_WON(GENERATION_WON_IDX,GENERATION_IDX,TELL,NAME) values(SC_GENERATIONW_IDX.nextval,#{generationIdx},#{tell},#{name})")
	int insertGenerationWonAdd(GenerationWon generationWon);
	
	//세대 전체 조회
	@Select("select * from TB_GENERATION where GENERATION_IDX = #{generationIdx}")
	Generation selectGeneration(Generation generation);
	
	int updateGenerationModify(Generation generation);
	
	@Update("update TB_GENERATION set email = #{email} where GENERATION_IDX = #{generationIdx}")
	int updateGenerationEmail(Generation generation);
}

