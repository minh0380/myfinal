package com.kh.aboo.common.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.kh.aboo.common.code.Configcode;

//Spring을 통해서 사용하기 위해 @Component를 붙여준다.
@Component
//비동기로 동작할 수 있도록 해줌
@EnableAsync //Async 어노테이셩을 해당 클래스에서 사용할 수 있게 해줌
public class MailSender {
	
	private final JavaMailSender mail;
	
	public MailSender(JavaMailSender mail) {
		this.mail = mail;
	}
	
	//새로운 thread를 생성해 메서드를 비동기로 실행할 수 있도록 처리
	//실행결과로 반환해야 할 값이 있다면 Future타입의 객체를 반환하고, Future 객체를 통해 실행의 결과값을 가져올 수 있다.
	@Async //스프링이 얘를 위한 스레드를 따로 만들어서 돌려줄 것임. 개발자는 싱글스레드인 것처럼 개발을 할 수 있다. 개발자가 직접 스레드를 만들지 않아도 된다.
	public void send(String to, String subject, String htmlText) {
		MimeMessage msg = mail.createMimeMessage();
		try {
			msg.setFrom(Configcode.EMAIL.desc);
			msg.setRecipients(Message.RecipientType.TO, to);
			msg.setSubject(subject);
			msg.setContent(htmlText, "text/html; charset=UTF-8");
			
			mail.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
