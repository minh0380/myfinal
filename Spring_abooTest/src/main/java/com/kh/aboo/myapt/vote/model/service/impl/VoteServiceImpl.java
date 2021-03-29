package com.kh.aboo.myapt.vote.model.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.batch.core.step.tasklet.ConfigurableSystemProcessExitCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.aboo.common.util.http.HttpUtils;
import com.kh.aboo.myapt.vote.model.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void authToVote(String tell) {
		String method = "POST";
		//String url = "https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:265114542753:aboo/messages";
		String url = "/sms/v2/services/ncp:sms:kr:265114542753:aboo/messages";
		String timestamp = Long.toString(System.currentTimeMillis());
		System.out.println(timestamp);
		String accessKey = "XZ23fBAH16NMQ1qUq0ll";
		String secretKey = "W4qIGuV0Fq1dhDTK4ett0CEfESnIDZRNflxG9Guo";
		
		String signature = makeSignature(url, timestamp, method, accessKey, secretKey);
		System.out.println(signature);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		//header.setContentType(MediaType.APPLICATION_JSON);
		//header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.add("x-ncp-apigw-timestamp", timestamp);
		header.add("x-ncp-iam-access-key", accessKey);
		header.add("x-ncp-apigw-signature-v2", signature);
		
		String certNum = makeCertNum();
		
		JSONObject params = new JSONObject();
		JSONObject params2 = new JSONObject();
		JSONArray messages = new JSONArray();
		try {
			params.put("type", "SMS");
			params.put("from", "01028906219");
			params.put("content", "[ABOO:아파트를 부탁해] 인증번호 [" + certNum + "] 을 입력해주세요.");
			params2.put("to", "01028906219");
			messages.put(params2);
			params.put("messages", messages);
			String body = params.toString();
			System.out.println(body);
			
			RequestEntity<String> request = 
					RequestEntity
					.post("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:265114542753:aboo/messages")
					.headers(header)
					.body(body);
			
			URI uri = new URI(url);
			
			System.out.println("헤더"+request.getHeaders());
			System.out.println("바디"+request.getBody());
			
			ResponseEntity<String> response = restTemplate.exchange(request, String.class);
			System.out.println("코드"+response.getStatusCode());
			
		} catch (JSONException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		JSONObject param = new JSONObject();
		
		try {
			param.put("to", "01028906219");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		body.add("type", "SMS");
		body.add("from", "01028906219");
		body.add("content", "[ABOO:아파트를 부탁해] 인증번호 [" + certNum + "] 을 입력해주세요.");
		body.add("messages.to", "01028906219");
		
		RequestEntity<MultiValueMap<String, String>> request = 
				RequestEntity
				.post("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:265114542753:aboo/messages")
				.headers(header)
				.body(body);
		
		System.out.println("헤더"+request.getHeaders());
		System.out.println("바디"+request.getBody());
		
		ResponseEntity<String> response = restTemplate.exchange(request, String.class);
		System.out.println(response.getBody());*/
		
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
		System.out.println("생성된 인증번호 : " + certNum);
		
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

}
