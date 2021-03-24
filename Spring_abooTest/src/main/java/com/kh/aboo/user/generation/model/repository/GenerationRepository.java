package com.kh.aboo.user.generation.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.user.generation.model.vo.Generation;

@Mapper
public interface GenerationRepository {	
	
	@Select("select * from TB_GENERATION where ID = #{Id} and IS_DEL = 0")
	public Generation selectGenerationForAuth(String Id);
	
	@Insert("insert into TB_GENERATION(GENERATION_IDX,APARTMENT_IDX,ID,PASSWORD,BUILDING,NUM) values(SC_GENERATION_IDX.nextval,'100000',#{id},#{password},'101','101')")
	public int insertGeneration(Generation generation);
}

