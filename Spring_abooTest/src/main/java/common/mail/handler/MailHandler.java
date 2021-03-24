package common.mail.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//요청을 받아들일 수 있어야 하므로
@Controller
public class MailHandler {
	
	@PostMapping("mail")
	public String writeMail(/*@RequestBody*/@RequestParam Map<String, Object> data, /*@RequestHeader Map<String, Object> header,*/ Model model) {
		//찍어보면 contentType이 application/json으로 찍힘. 이게 디폴트라서. >> data에 붙은 어노테이션을 @RequestBody로 바꿔준다.
		//System.out.println(header);
		System.out.println(data);
		//jsp에 뿌려줄 데이터를 모델이 담아준다.
		model.addAllAttributes(data);
		//view
		return "mail-temp/" + data.get("mail-template");
	}
	
}
