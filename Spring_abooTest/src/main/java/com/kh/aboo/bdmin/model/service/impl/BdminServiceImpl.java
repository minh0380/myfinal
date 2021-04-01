package com.kh.aboo.bdmin.model.service.impl;

import org.springframework.stereotype.Service;

import com.kh.aboo.bdmin.model.repository.BdminRepository;
import com.kh.aboo.bdmin.model.service.BdminService;
import com.kh.aboo.bdmin.model.vo.Bdmin;

@Service
public class BdminServiceImpl implements BdminService{

	private final BdminRepository bdminRepository;
	
	public BdminServiceImpl(BdminRepository bdminRepository) {
		this.bdminRepository = bdminRepository;
	}

	@Override
	public Bdmin selectBdminForAuth(Bdmin bdmin) {
		Bdmin bdminInfo = bdminRepository.selectBdminForAuth(bdmin);
		if(bdminInfo == null || !bdmin.getPassword().equals(bdminInfo.getPassword())) {
			return null;
		}
		return bdminInfo;
	}

	
	
}
