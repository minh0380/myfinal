package com.kh.aboo.bdmin.notice.model.service;

import java.util.Map;

import com.kh.aboo.bdmin.notice.model.vo.Notice;

public interface NoticeService {
	
	int insertNotice(Notice notice);
	Map<String, Object> selectNoticeList(int currentPage);
	Notice selectNoticeByIdx(String nNo);
	int updateNotice(Notice notice);
	int deleteNotice(String nNo);
	
}
