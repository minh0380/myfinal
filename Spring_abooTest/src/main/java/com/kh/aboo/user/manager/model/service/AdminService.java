package com.kh.aboo.user.manager.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.aboo.user.manager.model.vo.Admin;


public interface AdminService {
	//선영
	Admin selectGenerationForAuth(Admin admin);

	void insertAdmin(Admin admin);

}
