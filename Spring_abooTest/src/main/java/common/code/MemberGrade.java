package common.code;

//enum(enumerated type) : 열거형, 서로 연관된 상수들의 집합
//	서로 연관된 상수들을 편하게 다루기 위해 enum만의 문법적인 형식과 method를 제공
public enum MemberGrade {
	
	//enum 내부에서 사용할 enum인스턴스를 생성해야 한다. 규칙! >> enum을 만들 때 규칙임
	
	//회원등급코드, 회원등급, 등급별 연장 횟수
	//일반회원 - 연장가능 횟수 : 1
	
	//아래의 ME00("일반", 1)은
	//public static final MemberGrade ME00 = new MemberGrade("일반", 1); 와 동일
	ME00("일반", 1), //desc와 extendableCnt 등 연관된 상수들을 관리하기 편하라고 사용하는 게 enum
	//성실회원 - 연장가능 횟수 : 2
	ME01("성실", 2),
	//우수회원 - 연장가능 횟수 : 3
	ME03("우수", 3),
	//vip회원 - 연장가능 횟수 : 4
	ME04("VIP", 4); //더이상 만들 enum인스턴스가 없을 때 ;을 쓴다. 그 전까진 ,으로 연결
	
	//Code 설명
	private String desc;
	//회원 등급별 연장 횟수
	private int extendableCnt;
	
	//생성자의 접근제한자 생략, default로 private으로 지정이 되어 있다.
	//외부에서 enum의 인스턴스를 생성하는 것을 방지
	MemberGrade(String desc, int extendableCnt){
		this.desc = desc;
		this.extendableCnt = extendableCnt;
	}
	
	public String desc() {
		return desc;
	}
	
	public int extendableCnt() {
		return extendableCnt;
	}

}
