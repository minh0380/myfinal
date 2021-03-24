package com.kh.toy.member.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.vo.Member;

//스프링이 관리하는 bean으로 등록해준다.
@Component
public class MemberValidator implements Validator {
	
	private final MemberRepository memberRepository;
	
	public MemberValidator(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	//어떤 조건의 컨트롤러 메서드 파라미터를 검증할 것인지 작성
	@Override
	public boolean supports(Class<?> clazz) {
		//Class<?> clazz : 컨트롤러 파라미터의 class 객체
		return Member.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Object target : 컨트롤러 메서드의 파라미터
		//Errors : 검증에 실패할 경우 내용을 저장할 Error 객체, 컨트롤러 메서드의 파라미터로 전달된다.
		//유효성 검사하기 >> front와 back에서 둘다 하는게 제일 좋음
		//front에서 유효성 검사하면 사용자가 편하고
		//back에서 유효성 검사하면 악질적인 사용자를 막기에 적합하기 때문
		//join.jsp에서 정규표현식 앞뒤에 /를 넣었던건 이게 정규표현식임을 알려주기 위해 붙였던 것임.
		Pattern pattern = Pattern.compile("^(?!.*[ㄱ-힣])(?=.*\\W)(?=.*\\d)(?=.*[a-zA-Z])(?=.{8,})");
		Member persistInfo = (Member) target;
		
		//1. 사용자가 넘긴 아이디가 존재하지 않는 아이디가 맞는지
		if(memberRepository.selectMemberById(persistInfo.getUserId()) != null) {
			errors.rejectValue("userId", "error.userId", "이미 존재하는 아이디입니다.");
		}
		
		//2. password가 8자리 이상 숫자, 영문자, 특수기호가 각 하나씩 들어있는지
		if(!pattern.matcher(persistInfo.getPassword()).find()) {
			errors.rejectValue("password", "error.password", "비밀번호는 숫자,영문자,특수문자 조합의 8글자 이상인 문자열입니다.");
		}
		
		//3. 사용자가 넘긴 이메일이 존재하지 않는 이메일인지
		if(memberRepository.selectMemberByEmail(persistInfo.getEmail()) > 0) {
			errors.rejectValue("email", "error.email", "이미 존재하는 이메일입니다.");
		}
		
		//4. 사용자가 넘긴 휴대폰 번호가 존재하지 않는 휴대폰 번호인지
		if(memberRepository.selectMemberByTell(persistInfo.getTell()) > 0) {
			errors.rejectValue("tell", "error.tell", "이미 존재하는 휴대폰 번호입니다.");
		}
		
	}

}
