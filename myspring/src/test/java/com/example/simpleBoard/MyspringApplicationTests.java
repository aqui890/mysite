package com.example.simpleBoard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simpleBoard.answer.Answer;
import com.example.simpleBoard.answer.AnswerRepository;
import com.example.simpleBoard.question.Question;
import com.example.simpleBoard.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class MyspringApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	
	
	@Test
	void contextLoads() {
		/*
		 * int cnt = 100;
		 * 
		 * for(int i = 1; i <= 100; i++) { Question q1 = new Question();
		 * q1.setSubject("제목" + cnt); q1.setContent("내용" + cnt);
		 * q1.setCreateDate(LocalDateTime.now()); this.questionRepository.save(q1); }
		 */
		
		
		/*
		List<Question> all = this.questionRepository.findAll();
		assertEquals(4, all.size());
		
		Question q = all.get(0);
		assertEquals("궁금합니다.", q.getSubject());
		*/
		
		/*
		Optional<Question> op = this.questionRepository.findById(4);
		
		if(op.isPresent()) {
			Question q = op.get();
			assertEquals("질문 내용입니다.", q.getContent());
		}
		*/
		
		/*
		this.questionRepository.deleteById(1);
		this.questionRepository.deleteById(2);
		*/
		
		/*
		Question q = this.questionRepository.findBySubjectAndContent("궁금합니다.", "질문 내용입니다.");
		assertEquals(3, q.getId());
		*/
		
		/*
		List<Question> qList = this.questionRepository.findBySubjectLike("%니다%");
		Question q = qList.get(0);
		System.out.println(q.getSubject());
		*/
		
		/*
		Optional<Question> q = this.questionRepository.findById(3);
		assertTrue(q.isPresent());
		Question question = q.get();
		question.setSubject("수정된 제목");
		this.questionRepository.save(question);
		*/
		
		
		/*
		int cnt = 100;
		
		
		for(int i = 1; i <= 50; i++) {			
			Question q1 = new Question();
			q1.setSubject("테스트코드를 이용해 상세한 내용 [내용" + cnt + "]");
			q1.setContent("테스트코드를 이용해 생성한 제목 [제목" + cnt + "]");
			q1.setCreateDate(LocalDateTime.now());
			this.questionRepository.save(q1);
			
		}
		*/
		
		/*
		 * Optional<Question> op = this.questionRepository.findById(4);
		 * assertTrue(op.isPresent()); Question q = op.get();
		 * 
		 * List<Answer> answerList = q.getAnswerList(); // 쌤 방법
		 * 
		 * System.out.println(answerList.get(0).getContent());
		 * System.out.println(answerList.size());
		 */
		
		/*
		 * 내방법
		 * List<Answer> a = this.answerRepository.findByQuestion(q);
		 * System.out.println(a.get(0).getContent());
		 */
		
	}

}
