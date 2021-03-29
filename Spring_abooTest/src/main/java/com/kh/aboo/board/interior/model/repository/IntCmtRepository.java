package com.kh.aboo.board.interior.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.aboo.board.interior.model.vo.IntCmt;

@Mapper
public interface IntCmtRepository {
	
	@Insert("insert into tb_int_cmt(int_cmt_no, int_post_no, int_cmt_content, int_cmt_writer, generation_idx) "
			+ "values(sc_int_cmt_idx.nextval, #{intPostNo}, #{intCmtContent}, #{intCmtWriter}, #{generationIdx})")
	int insertIntCmt(IntCmt intCmt);
	
	@Select("select * from tb_int_cmt where int_post_no = #{intPostNo} and int_cmt_is_del = 0")
	List<IntCmt> selectIntCmtByIntPostNo(@Param(value = "intPostNo") String intPostNo);
	
	@Select("select count(*) from tb_int_cmt where int_post_no = #{intPostNo} and int_cmt_is_del = 0")
	int selectIntCmtCnt(@Param(value = "intPostNo") String intPostNo);
	
	@Update("update tb_int_cmt set int_cmt_is_del = 1 where int_cmt_no = #{intCmtNo}")
	int deleteIntCmt(@Param(value = "intCmtNo") String intCmtNo);
	
	@Update("update tb_int_cmt set int_cmt_content = #{intCmtContent} where int_cmt_no = #{intCmtNo}")
	int updateIntCmt(IntCmt intCmt);
	
	@Update("update tb_int_cmt set int_cmt_is_private = 1 where int_cmt_no = #{intCmtNo}")
	int updateIntCmtIsPrivate(@Param(value = "intCmtNo") String intCmtNo);
	
}
