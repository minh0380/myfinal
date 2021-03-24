package com.kh.aboo.common.code;

public enum ErrorCode {
	
	SM01("회원 정보를 조회하는 도중 에러가 발생하였습니다."),
	IM01("회원 정보를 입력하는 도중 에러가 발생하였습니다."),
	UM01("회원정보 수정 중 에러가 발생하였습니다."),
	DM01("회원정보 삭제 중 에러가 발생하였습니다."),
	FILE01("파일 업로드 중 에러가 발생하였습니다."),
	IB01("게시글 작성 중 에러가 발생하였습니다"),
	IF01("파일 업로드 중 에러가 발생하였습니다."),
	AUTH01("해당 페이지에 접근하실 수 없습니다.","/member/login.do"),
	AUTH02("이미 인증이 만료된 링크입니다."),
	MAIL01("메일 발송 중 에러가 발생했습ㅂ니다."),
	API01("API통신 도중 에러가 발생하였습니다."),
	CD_404("존재하지 않는 경로입니다.");
	
	//result.jsp를 사용해 띄울 안내문구 
	private String errMsg;
	//result.jsp를 사용해 이동시킬 경로
	private String url = "/index";
	
	// index로 이동시킬 경우 에러메시지만 받는다.
	ErrorCode(String errMsg) {
		this.errMsg = errMsg;
	}
	
	//index이외의 지정페이지로 이동시 url도 같이 받는다.
	ErrorCode(String errMsg, String url) {
		this.errMsg = errMsg;
		this.url = url;
	}
	
	public String errMsg() {
		return errMsg;
	}
	
	public String url() {
		return url;
	}

}
