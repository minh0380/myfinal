package com.kh.aboo.user.generation.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.aboo.user.generation.model.repository.GenerationRepository;
import com.kh.aboo.user.generation.model.service.GenerationService;
import com.kh.aboo.user.generation.model.vo.Generation;

@Service
public class GenerationServiceImpl implements GenerationService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	private final GenerationRepository generationRepository;

	public GenerationServiceImpl(GenerationRepository generationRepository) {
		this.generationRepository = generationRepository;
	}

	@Override
	public Generation selectGenerationForAuth(Generation generation) {

		Generation authInfo = generationRepository.selectGenerationForAuth(generation.getId(), generation.getPassword());
		if (authInfo == null) {
			return null;
		}

		return authInfo;
	}

}
