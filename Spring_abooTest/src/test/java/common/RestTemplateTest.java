package common;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class RestTemplateTest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void kakaoAPITest() {
		
		// HttpHeaders(MultiValueMap의 구현체)에 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 7a43641677a7afad2ff3976498a5219f");
		
		// HttpEntity 생성
		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<Map<String,String>>(headers);
		
		// RestTemplate 생성 
		ResponseEntity<Map> res = restTemplate.exchange("https://dapi.kakao.com/v2/search/web?query=브레이브걸스"
				, HttpMethod.GET
				, httpEntity
				, Map.class);
		
		System.out.println(res.getHeaders());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusCodeValue());
		System.out.println(res.getBody());
	}
}
