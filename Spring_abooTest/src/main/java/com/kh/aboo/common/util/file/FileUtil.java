package com.kh.aboo.common.util.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.kh.aboo.common.code.Configcode;

public class FileUtil {
	
	public List<FileVO> fileUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		//파일 메타정보를 가지고 반환될 list
		List<FileVO> fileDatas = new ArrayList<>();
		
		//파일이 저장될 경로
		String savePath = getSavePath();
		//파일을 첨부하지 않아도 multipartFile length가 1로 잡히고 0KB 파일이 저장됨.
		//그래서 예외처리 필요
		if(files.size() >= 1 && !files.get(0).getOriginalFilename().equals("")) {
			for (MultipartFile multipartFile : files) {
				//저장될 파일명
				String renameFileName = UUID.randomUUID().toString();
				//원본 파일명
				String originFilename = multipartFile.getOriginalFilename();
				
				FileVO fileVo = new FileVO();
				fileVo.setOriginFileName(originFilename);
				fileVo.setRenameFileName(renameFileName);
				fileVo.setSavePath(savePath);
				fileDatas.add(fileVo);
				
				saveFile(multipartFile, fileVo);
				
			}
		}
		
		return fileDatas;
		
	}
	
	private String getSavePath() {
		
		//파일이 저장될 경로
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR)
				+ "/" + (cal.get(Calendar.MONTH) + 1)
				+ "/" + cal.get(Calendar.DAY_OF_MONTH) + "/";
		
	}
	
	private void saveFile(MultipartFile multipartFile, FileVO fileVo) throws IllegalStateException, IOException {
		
		File file = new File(fileVo.getFullPath() + fileVo.getRenameFileName());
		if(!file.exists()) {
			new File(fileVo.getFullPath()).mkdirs();
		}
		
		//FileUtil에서가 아닌 Spring이 동작하는 Service, Controller에서 처리해야 ExceptionHandler를 활용할 수 있기 때문에 예외를 던진다.
		//예외처리에 spring framework의 도움을 받기 위해서.
		multipartFile.transferTo(file);
		
	}
	
	public void deleteFile(String path, String renameFileName) {
		
		File file = new File(Configcode.UPLOAD_PATH + path + renameFileName);
		file.delete();
		
	}
	
}
