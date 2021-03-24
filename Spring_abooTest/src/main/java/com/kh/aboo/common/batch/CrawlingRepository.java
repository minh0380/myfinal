package com.kh.aboo.common.batch;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrawlingRepository {
	
	@Insert("insert into tb_baseball(rank, team_name, match, win, lose, tie, rate) "
			+ "values(#{rank},#{teamName},#{match},#{win},#{lose},#{tie},#{rate})")
	int insertBaseball(Map<String, String> commandMap);
	
}
