package com.kh.aboo.common.code;

public enum Configcode {
	
	DOMAIN("http://localhost:8989"),
	EMAIL("choayoung91@naver.com"),
	// 파일저장을 내부에 해버리면 배포할때 다 날라간다, 꼭 외부 파일경로 지정해서 업로드해주자!
	UPLOAD_PATH("E:\\CODE\\05_Servlet\\resources\\upload\\");
	
	public String desc;
	
	private Configcode(String desc) {
		// TODO Auto-generated constructor stub
		this.desc = desc;
	}
	
	public String toString() {
		return desc;
	}

}
