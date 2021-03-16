package com.kh.toy.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration // 프로젝트의 web.xml 대신 테스트를 위해 생성된 가상 web.xml 사용한다.
@RunWith(SpringJUnit4ClassRunner.class) // Junit 단위테스트 프레임워크의 실행방법을 지정해준다. 테스트때 사용할 가상의 applicationContext를 생성하고 관리해준다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"}) //가상 applicationContext 가 읽을 스프링 빈 설정파일의 위치를 지정.
public class MemberControllerTest {
   
   @Autowired
   private WebApplicationContext context; //목mvc만들때 필요
   
   // 컨트롤러를 테스트하기 위해서는 http request 를 발생시켜 디스패처서블릿을 통해 컨트롤러를 호출
   // 서버를 올리지않고 테스트하기 위해 가상의 request를 발생시킬 mockMvc객체 생성
   private MockMvc mockMvc;
   
   //테스트 전 실행할 메서드
   @Before
   public void setup() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
   }
   
   @Test
   public void joinTest() throws Exception {
      mockMvc.perform(get("/member/join")).andDo(print());
   }
   
   @Test
   public void idCheckTest() throws Exception {
      mockMvc.perform(get("/member/idcheck").param("userId","choayoung91")).andDo(print());
   }
   
   @Test
   public void authenicateEmail() throws Exception {
	   mockMvc.perform(post("/member/mailauth")
			   .param("userId", "helloSpring")
			   .param("password", "112119")
			   .param("email", "choayoung1204@gmail.com")
			   .param("tell", "010-4144-4444"))
	   .andDo(print());
   }
   
}