package com.kh.toy.member.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.member.model.vo.Member;


@Mapper
public interface MemberRepository {
	
	// 아이디로 회원을 조회해서 나온 결과를 Member 객체에 매핑
	@Select("SELECT * FROM tb_member WHERE user_id = #{userId}")
	Member selectMemberById(String userId);

}
