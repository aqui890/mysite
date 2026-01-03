package com.example.demo;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyspringApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void contextLoads() {
		Question q1 = new Question();
		q1.setSubject("궁금합니다.");
		q1.setContent("질문 내용입니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("사실인가요?");
		q2.setContent("공룡이 존재 했다는 사실이 진정 true 입니까?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

}
