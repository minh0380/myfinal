package common.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

// 어디서든 사용가능한 우리만의 MailSender 구현.
// 외부 패키지 생성하는 경우에도 servlet-context에 해당 경로 추가해주어 관리대상으로 만든다.
// 그러면 어노테이션 사용 가능. -> bean 등록한다 (@Component)

@Component
public class MailSender {
	// 1. 스프링으로부터 MailSender 의존성 주입 받기 (안전한 라이브러리니까 바로 주입)
	// 2. 메일 보내기위해 MimeMessage 구현해야하는데 이안에 또 4가지를 구현해야한다.
	
	// 오토와이어드 해도되는데~ 혹시모르니까 생성자주입으로 변경
	private final JavaMailSender mail;
	
	public MailSender(JavaMailSender mail) {
		this.mail = mail;
	}
	
	public void send(String to, String subject, String htmlText) {
		
		MimeMessage msg = mail.createMimeMessage();
		try {
			msg.setFrom("choayoung91@naver.com"); 
			msg.setRecipients(Message.RecipientType.TO, to); //받는사람
			msg.setSubject(subject);
			msg.setContent(htmlText, "text/html; charset=UTF-8");
			mail.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
