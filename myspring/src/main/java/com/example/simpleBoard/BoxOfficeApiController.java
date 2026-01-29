package com.example.simpleBoard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class BoxOfficeApiController {

	@GetExchange("/api/boxoffice")
	public ResponseEntity<String> boxOffice(@RequestParam("targetDate") String targetDate) {
		System.out.println("api 호출됨: ");
		
		try {
			String apiKey = "7f15d8077a11311704a6b9142f74f4e8";
			
			String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json" + "?key=" + apiKey + "&targetDt=" + targetDate;
			RestTemplate restTemplate =  new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			
			
			return ResponseEntity.ok(result);
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("영화 open api 호출 실패");
		}
	}
}
