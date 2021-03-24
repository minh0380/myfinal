package com.kh.aboo.user.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kh.aboo.user.admin.model.vo.Admin;
import com.kh.aboo.user.admin.model.vo.Mgmtfee;


public interface AdminService {
	//선영
	Admin selectGenerationForAuth(Admin admin);

	void insertAdmin(Admin admin);
		
	//아영 관리비업로드 파일 읽기
	Map<String, Object> mgmtfeeRead(MultipartFile file);
	
	//아영 관리비 mgmtfee vo에 넣어 DB에 추가하기.
	List<Mgmtfee> addMgmtfee(Map<String,Object> commandMap);


}
