package common.batch;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CrawlingBatch {
	
	//웹크롤링은 스프링이 제공하는 기능이 아니지만, batch는 스프링이 기능 제공해줌.
	
	@Autowired
	RestTemplate rt;
	
	@Autowired //땡겨온다는 느낌으로 기억하기
	CrawlingRepository crawlingRepository;
	
	//초 분 시 일 월 요일 연도(스프링에서는 사용하지 않음)
	// * : 모든
	// , : 복수 값을 지정할 수 있음
	// 시작시간/단위 : 0/5 * * * * * : 매월 매일 매시 매분 0초에 시작해서 5초마다 반복
	
	//5 * * * * * : 매분 5초마다 해당 스케줄이 돈다.
	//30 15 * * * * : 매시간 15분 30초마다
	//30 0 3 30 4,8,12 * : 4,8,12월 30일 3시 0분 30초마다
	
	@Scheduled(cron = "5 5 5 5 5 *")
	public void crawlingBaseBall() {
		
		File file = new File("E:\\CODE\\06_Spring\\resources\\image\\test.jpg");
		
		System.out.println("test batch");
		try {
			UrlResource resource = new UrlResource("https://img4.yna.co.kr/photo/cms/2019/05/02/02/PCM20190502000402370_P2.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			
			BufferedInputStream bis = new BufferedInputStream(resource.getInputStream());
			
			bos.write(resource.getInputStream().readAllBytes());
			
			Document doc = 
					Jsoup.parse(new URL("https://www.koreabaseball.com/TeamRank/TeamRank.aspx"), 5000);
			Elements teamScore = doc.select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr");
			String[] colArr = {"rank", "teamName", "match", "win", "lose", "tie", "rate"};
			
			for (Element element : teamScore) {
				//System.out.println(element.children()); //<tr>의 자식요소인 <td>만 출력됨.
				Map<String, String> data = new LinkedHashMap<>(); //순서 보장을 위해 LinkedHashMap 활용
				for (int i = 0; i < 7; i++) {
					data.put(colArr[i], element.children().get(i).text());
				}
				crawlingRepository.insertBaseball(data);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void crawlingOcean() {
		
		Document doc;
		try {
			//다른경로로 요청해서 페이지를 다시 그리는 경우 불러올 수 없게 됨 >> 경로를 그 요청하는 다른경로로 바꿔주면 됨.
			//doc = Jsoup.parse(new URL("http://www.khoa.go.kr/oceangrid/khoa/koofs.do"), 5000); //여기서 F12 network에서 보면 다른 경로에서 받아온다는 걸 알 수 있음.
			doc = Jsoup.parse(new URL("http://www.khoa.go.kr/oceangrid/koofs/kor/observation/obs_real_list.do"), 5000);
			Elements els = doc.select("body > ul");
			System.out.println("test: " + els);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
