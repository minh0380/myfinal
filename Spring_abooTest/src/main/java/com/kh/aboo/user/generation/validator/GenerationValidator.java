package com.kh.aboo.user.generation.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.aboo.user.generation.model.repository.GenerationRepository;
import com.kh.aboo.user.generation.model.vo.Generation;

@Component
public class GenerationValidator implements Validator{

	
	private final GenerationRepository generationRepository;
	
	public GenerationValidator(GenerationRepository generationRepository) {
		this.generationRepository = generationRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Generation.class.equals(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		Pattern pattern = Pattern.compile("^(?!.*[ㄱ-힣])(?=.*\\W)(?=.*\\d)(?=.*[a-zA-Z])(?=.{8,})");
		Generation generation = (Generation) target;
		
		
		if (!pattern.matcher(generation.getPassword()).find()) {
			errors.rejectValue("password","error.password","비밀번호는 숫자,영문자,특수문자 조합의 8글자 이상인 문자열입니다1.");
		}
			
	}
	

	
	
	
}
