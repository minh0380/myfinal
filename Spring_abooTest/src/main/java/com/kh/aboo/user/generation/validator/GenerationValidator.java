package com.kh.aboo.user.generation.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

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
		
	}
	

	
	
	
}
