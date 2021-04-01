package com.kh.aboo.bdmin.notice.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.bdmin.notice.model.vo.Notice;
import com.kh.aboo.common.util.paging.Paging;

@Mapper
public interface NoticeRepository {
	
	@Insert("insert into tb_notice(n_no, n_title, n_content) values(sc_notice_idx.nextval, #{nTitle}, #{nContent})")
	int insertNotice(Notice notice);
	
	List<Notice> selectNoticeList(Paging paging);
	
	@Select("select count(*) from tb_notice where n_is_del = 0")
	int selectNoticeCnt();
	
	@Select("select * from tb_notice where n_no = #{nNo}")
	Notice selectNoticeByIdx(@Param(value = "nNo") String nNo);
	
}
