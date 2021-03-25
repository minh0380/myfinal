package com.kh.aboo.user.manager.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.user.manager.model.vo.Admin;

@Mapper
public interface AdminRepository {

	
	@Select("select * from TB_MANAGER where ID = #{Id} and IS_DEL = 0")
	public Admin selectGenerationForAuth(String Id);
	
	@Insert("insert into TB_MANAGER(PARTNER_IDX,APARTMENT_IDX,ID,PASSWORD,NAME,EMAIL,TELL,BIRTH) values(SC_MANAGER_IDX.nextval,'100000',#{id},#{password},#{name},#{email},#{tell},#{birth})")
	public int insertAdmin(Admin admin);
	
}	
