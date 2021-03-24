package com.kh.aboo.user.generation.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.user.generation.model.vo.Generation;

@Mapper
public interface GenerationRepository {	
	
	@Select("select * from TB_GENERATION where ID = #{id} and PASSWORD = #{password} and IS_DEL = 0")
	public Generation selectGenerationForAuth(@Param(value = "id") String id, @Param(value = "password") String password);

}

