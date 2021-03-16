package common.exception;

import common.code.ErrorCode;

public class DataAccessException extends CustomException{

	private static final long serialVersionUID = 1680506238142341928L;
	//예외처리가 강제되지 않은 예외클래스 생성
	//select절은 commit이 필요하지 않아서 언체크드 예외처리로 생성해줄거임.

	// SQL Exception 을 unchecked로 감싸기 위해 사용하는 예외
	public DataAccessException(ErrorCode error, Exception e) {
		super(error,e);
		
	}
}
