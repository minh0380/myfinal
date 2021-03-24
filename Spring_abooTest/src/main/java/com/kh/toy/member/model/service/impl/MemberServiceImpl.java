package com.kh.toy.member.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;

import common.code.Configcode;
import common.mail.MailSender;

@Service
public class MemberServiceImpl implements MemberService{
	
	//MemberService(interface)의 구현체를 여기에 작성 >> 그래야 aop 활용 가능.
	private final MemberRepository memberRepository;
	
	@Autowired
	private MailSender mail;
	@Autowired
	private RestTemplate http;
	@Autowired //bcrypt를 spring이 MemberServiceImpl에 넣어줌. 이거 안해주면 encoder가 null이라서 에러남.
	private PasswordEncoder encoder;
	
	//thread safe를 위해 생성자 의존성 주입 방식을 사용한다.
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public Member selectMemberById(String userId) {
		return memberRepository.selectMemberById(userId);
	}

	@Override
	public void authenticateEmail(/*Map<String, String>*/Member persistInfo, String authPath) {
		/*MimeMessage msg = mail.createMimeMessage();
		try {
			msg.setFrom("minh0380@naver.com");
			msg.setRecipients(Message.RecipientType.TO, persistInfo.get("email"));
			msg.setSubject("회원가입을 축하드립니다.");
			msg.setContent(persistInfo.get("userId") + "님!", "text/html; charset=UTF-8");
			
			mail.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//persistInfo.put("mail-template", "temp_join");
		
		//내부적으로 Map<String, List<k>> 를 구현
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		//body.setAll(persistInfo);
		body.add("mail-template", "temp_join");
		body.add("userId", persistInfo.getUserId());
		body.add("authPath", authPath);
		
		//RestTemplate의 기본 Content-type은 application/json
		//Content-type을 form-url-encoded로 설정해서 통신해보기 >> MailHandler에서 data의 어노테이션을 @RequestParam으로 바꿔준다.
		RequestEntity<MultiValueMap<String, String>> request = 
				RequestEntity
				.post(Configcode.DOMAIN+"/mail")
				.header("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE) //Content-type을 form-url-encoded로 설정해서 통신해보기 할때 이렇게 붙여서 ContentType 지정해주면 됨.
				.body(body);
		
		ResponseEntity<String> response = http.exchange(request, String.class);
		//String message = response.getBody();
		
		//동기적으로 움직이기 때문에 controller에 응답하고 메일을 보내느라 딜레이가 생김
		//따라서 메일을 보내는 스레드를 따로 만들어서 응답과 메일발송을 따로 하도록 만들면 딜레이가 줄어든다.
		//@Async를 이용하면 메일을 보낼때까지 기다리지 않고 바로 alert 응답을 한다.
		//long before = System.nanoTime();
		mail.send(persistInfo.getEmail(), "회원 가입을 축하드립니다.", /*message*/response.getBody());
		//long after = System.nanoTime();
		//System.out.println(after - before);
	}

	@Override
	public int selectMemberByEmail(String email) {
		return memberRepository.selectMemberByEmail(email);
	}

	@Override
	public int selectMemberByTell(String tell) {
		return memberRepository.selectMemberByTell(tell);
	}

	@Override
	public int insertMember(Member persistInfo) {
		persistInfo.setPassword(encoder.encode(persistInfo.getPassword()));
		return memberRepository.insertMember(persistInfo);
	}
	
	@Override
	public Member authenticateUser(Member member) {
		Member authInfo = memberRepository.selectMemberForAuth(member.getUserId());
		if(authInfo == null ||
				!encoder.matches(member.getPassword(), authInfo.getPassword())) {
			return null;
		}
		
		return authInfo;
	}
	
}
