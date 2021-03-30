package com.kh.aboo.myapt.vote.model.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.aboo.myapt.vote.model.repository.VoteRepository;
import com.kh.aboo.myapt.vote.model.service.VoteService;
import com.kh.aboo.myapt.vote.model.vo.AuthToVote;
import com.kh.aboo.myapt.vote.model.vo.VoteGen;

@Service
public class VoteServiceImpl implements VoteService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final VoteRepository voteRepository;
	
	public VoteServiceImpl(VoteRepository voteRepository) {
		this.voteRepository = voteRepository;
	}

	@Override
	public int authToVote(String tell, HttpSession session) {
		String method = "POST";
		String url = "/sms/v2/services/ncp:sms:kr:265114542753:aboo/messages";
		String timestamp = Long.toString(System.currentTimeMillis());
		String accessKey = "XZ23fBAH16NMQ1qUq0ll";
		String secretKey = "W4qIGuV0Fq1dhDTK4ett0CEfESnIDZRNflxG9Guo";
		
		String signature = makeSignature(url, timestamp, method, accessKey, secretKey);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		header.add("x-ncp-apigw-timestamp", timestamp);
		header.add("x-ncp-iam-access-key", accessKey);
		header.add("x-ncp-apigw-signature-v2", signature);
		
		String certNum = makeCertNum();
		session.setAttribute("certNumToVote", certNum);
		
		JSONObject params = new JSONObject();
		JSONObject params2 = new JSONObject();
		JSONArray messages = new JSONArray();
		try {
			params.put("type", "SMS");
			params.put("from", "01028906219");
			params.put("content", "[ABOO:아파트를 부탁해] 본인 확인을 위해 인증번호 [" + certNum + "]를 입력해주세요.");
			params2.put("to", tell);
			messages.put(params2);
			params.put("messages", messages);
			String body = params.toString();
			
			RequestEntity<String> request = 
					RequestEntity
					.post("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:265114542753:aboo/messages")
					.headers(header)
					.body(body);
			
			ResponseEntity<String> response = restTemplate.exchange(request, String.class);
			return response.getStatusCodeValue();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 400;
		
	}
	
	//인증번호 생성 메서드
	public String makeCertNum() {
		Random random = new Random();
		String certNum = "";
		
		for(int i = 0; i < 6; i++) {
			String rand = Integer.toString(random.nextInt(10));
			
			if(!certNum.contains(rand)) {
				certNum += rand;
			}else {
				i -= 1;
			}
		}
		
		return certNum;
	}
	
	public String makeSignature(String url, String timestamp, String method, String accessKey, String secretKey) {
		String space = " ";
		String newLine = "\n";
		
		String message = new StringBuilder().append(method).append(space)
				.append(url).append(newLine).append(timestamp).append(newLine)
				.append(accessKey).toString();
		
		SecretKeySpec signingKey;
		String encodeBase64String = "";
		
		try {
			signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.encodeBase64String(rawHmac);
 		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encodeBase64String;
		
	}

	@Override
	public int selectGenerationWonToAuth(AuthToVote authToVote) {
		return voteRepository.selectGenerationWonToAuth(authToVote);
	}

	@Override
	public String selectGenerationWonIdxToVote(AuthToVote authToVote) {
		return voteRepository.selectGenerationWonIdxToVote(authToVote);
	}

	@Override
	public String selectGenerationWonTellToVote(AuthToVote authToVote) {
		return voteRepository.selectGenerationWonTellToVote(authToVote);
	}

	@Override
	public int insertVoteGen(VoteGen voteGen) {
		return voteRepository.insertVoteGen(voteGen);
	}

	@Override
	public int selectIfParticipate(String generationIdx, String voteNo) {
		return voteRepository.selectIfParticipate(generationIdx, voteNo);
	}

}
