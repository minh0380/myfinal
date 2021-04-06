package com.kh.aboo.admin.index.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.aboo.admin.index.model.repository.IndexNoticeRepository;
import com.kh.aboo.admin.index.model.service.IndexNoticeService;
import com.kh.aboo.bdmin.notice.model.vo.Notice;

@Service
public class IndexNoticeServiceImpl implements IndexNoticeService {
	
	private final IndexNoticeRepository indexNoticeRepository;
	
	public IndexNoticeServiceImpl(IndexNoticeRepository indexNoticeRepository) {
		this.indexNoticeRepository = indexNoticeRepository;
	}

	@Override
	public List<Notice> selectIndexNotice() {
		return indexNoticeRepository.selectIndexNotice();
	}
	
}
