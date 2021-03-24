package com.kh.toy.member.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.member.model.vo.Member;

//@Repository : database에서 발생하는 SqlException을 DataAccessException으로 wrapping
//지금은 @Mapper로 여기서 발생하는 exception이 DataAccessException으로 wrapping 됨.
@Mapper
public interface MemberRepository {
	//아이디로 회원을 조회해서 나온 결과를 Member 객체에 매핑
	@Select("SELECT * FROM tb_member WHERE user_id = #{userId}")
	Member selectMemberById(String userId);
	
	@Select("select * from xx_member where user_id = #{userId} and is_leave = 0")
	Member selectMemberForAuth(String userId);
	
	@Select("select count(*) from tb_member where email = #{email}")
	int selectMemberByEmail(String email);
	
	@Select("select count(*) from tb_member where tell = #{tell}")
	int selectMemberByTell(String tell);
	
	/*나의 풀이
	@Insert("insert into tb_member(user_id, password, email, tell) values(#{persistInfo.userId}, #{persistInfo.password}, #{persistInfo.email}, #{persistInfo.tell})")
	int insertMember(@Param(value = "persistInfo") Member persistInfo);*/
	
	@Insert("insert into tb_member(user_id, password, email, tell) values(#{userId}, #{password}, #{email}, #{tell})")
	int insertMember(Member persistInfo);
}
