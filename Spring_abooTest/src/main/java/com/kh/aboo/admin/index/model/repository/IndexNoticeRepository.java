package com.kh.aboo.admin.index.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.bdmin.notice.model.vo.Notice;

@Mapper
public interface IndexNoticeRepository {
	
	@Select("select * from tb_notice where n_is_del = 0")
	List<Notice> selectIndexNotice();
	
}
