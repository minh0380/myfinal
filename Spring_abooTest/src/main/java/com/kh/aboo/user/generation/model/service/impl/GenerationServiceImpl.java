package com.kh.aboo.user.generation.model.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.aboo.common.code.Configcode;
import com.kh.aboo.common.mail.MailSender;
import com.kh.aboo.common.util.paging.Paging;
import com.kh.aboo.user.generation.model.repository.GenerationRepository;
import com.kh.aboo.user.generation.model.service.GenerationService;
import com.kh.aboo.user.generation.model.vo.Generation;
import com.kh.aboo.user.generationWon.model.vo.GenerationWon;

@Service
public class GenerationServiceImpl implements GenerationService {

	@Autowired
	private MailSender mail;

	@Autowired
	private RestTemplate http;

	@Autowired
	private PasswordEncoder encoder;

	private final GenerationRepository generationRepository;

	public GenerationServiceImpl(GenerationRepository generationRepository) {
		this.generationRepository = generationRepository;
	}

	@Override
	public Generation selectGenerationForAuth(Generation generation) {

		Generation authInfo = generationRepository.selectGenerationForAuth(generation.getId());
		if (authInfo == null || !encoder.matches(generation.getPassword(), authInfo.getPassword())) {
			return null;
		}

		return authInfo;
	}

	@Override
	public void insertGeneration(Generation generation) {
		generationRepository.insertGeneration(generation);
	}

	@Override
	public Generation selectFindId(Generation generation) {
		return generationRepository.selectFindId(generation);
	}

	@Override
	public void authenticationIdMail(Generation generation, String authPathId) {
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("mail-template", "findid");
		body.add("id", generation.getId());
		body.add("authPath", authPathId);
		RequestEntity<MultiValueMap<String, String>> request = RequestEntity.post(Configcode.DOMAIN + "/mail")
				.header("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE).body(body);
		
		ResponseEntity<String> response = http.exchange(request, String.class);
		String message = response.getBody();
		mail.send(generation.getEmail(), "메일", message);
					
	}

	@Override
	public Generation selectFindPassword(Generation generation) {
		return generationRepository.selectFindPassword(generation);
	}


	@Override
	public void authenticationPasswordMail(Generation generation, String password) {
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("mail-template", "findpassword");
		body.add("id", generation.getId());
		body.add("password",password);
		System.out.println("메일 보낼번호 : " +password);
		
		RequestEntity<MultiValueMap<String, String>> request = RequestEntity.post(Configcode.DOMAIN + "/mail")
				.header("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE).body(body);

		ResponseEntity<String> response = http.exchange(request, String.class);
		String message = response.getBody();
		mail.send(generation.getEmail(), "메일", message);		
		
		System.out.println("바뀔번호");
		generation.setPassword(encoder.encode(password));
		generationRepository.updateFindPassword(generation);
				
	}

	@Override
	public Map<String, Object> selectGenerationWonList(int currentPage, String generationIdx) {
		Paging paging = Paging.builder().currentPage(currentPage).blockCnt(5).cntPerPage(5).type("board")
				.total(generationRepository.selectContentCnt(generationIdx)).build();
		Map<String, Object> commandMap = new HashMap<String, Object>();
		Map<String, Object> generationMap = new HashMap<String, Object>();
		generationMap.put("paging", paging);
		generationMap.put("generationIdx", generationIdx);

		commandMap.put("paging", paging);
		commandMap.put("generationWonList", generationRepository.selectGenerationWonList(generationMap));
		
		return commandMap;
	}

	//세대원 수정
	@Override
	public int updateGenerationWonModify(GenerationWon generationWon) {
		return generationRepository.updateGenerationWonModify(generationWon);
	}

	//세대원 삭제
	@Override
	public int updateGenerationWonDelete(GenerationWon generationWon) {
		return generationRepository.updateGenerationWonDelete(generationWon);
	}
	
	//세대원 추가
	@Override
	public int insertGenerationWonAdd(GenerationWon generationWon) {
		return generationRepository.insertGenerationWonAdd(generationWon);
	}
	
	//세대 정보
	@Override
	public Generation selectGeneration(Generation generation) {
		return generationRepository.selectGeneration(generation);
	}

	@Override
	public int updateGenerationModify(Generation generation) {
		String password = generation.getPassword();
		generation.setPassword(encoder.encode(password));
		return generationRepository.updateGenerationModify(generation);
	}

	@Override
	public void authenticationEmail(Generation generation, String authPathEmail) {
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("mail-template", "email");
		body.add("id", generation.getId());
		body.add("authPath", authPathEmail);
		RequestEntity<MultiValueMap<String, String>> request = RequestEntity.post(Configcode.DOMAIN + "/mail")
				.header("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE).body(body);
		
		ResponseEntity<String> response = http.exchange(request, String.class);
		String message = response.getBody();
		mail.send(generation.getEmail(), "이메일 인증 메일", message);		
	}

	@Override
	public int updateGenerationEmail(Generation generation) {
		return generationRepository.updateGenerationEmail(generation);
	}

	
}
