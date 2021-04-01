package com.kh.aboo.bdmin.notice.model.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.aboo.bdmin.notice.model.repository.NoticeRepository;
import com.kh.aboo.bdmin.notice.model.service.NoticeService;
import com.kh.aboo.bdmin.notice.model.vo.Notice;
import com.kh.aboo.common.util.paging.Paging;

@Service
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;
	
	public NoticeServiceImpl(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}
	
	@Override
	public int insertNotice(Notice notice) {
		return noticeRepository.insertNotice(notice);
	}

	@Override
	public Map<String, Object> selectNoticeList(int currentPage) {
		Paging paging = Paging.builder()
				.currentPage(currentPage)
				.blockCnt(5)
				.cntPerPage(10)
				.type("notice")
				.total(noticeRepository.selectNoticeCnt())
				.build();
		
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("paging", paging);
		commandMap.put("noticeList", noticeRepository.selectNoticeList(paging));
		
		return commandMap;
	}

	@Override
	public Notice selectNoticeByIdx(String nNo) {
		return noticeRepository.selectNoticeByIdx(nNo);
	}
	
}
