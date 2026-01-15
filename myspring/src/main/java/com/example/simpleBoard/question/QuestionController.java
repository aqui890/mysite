package com.example.simpleBoard.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.simpleBoard.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionRepository questionRepository;
	
	private final QuestionService questionService;
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		Page<Question> paging =  this.questionService.getList(page);
		model.addAttribute("paging", paging);
		return "question_list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, AnswerForm answerForm, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	@GetMapping("/regist")
	public String questionCreatePage(QuestionForm questionForm) {
		return "question_regist";
	}
	
	// 목록 페이지로 이동
	@PostMapping("/create")
	public String createQeustion(@Valid QuestionForm questionForm,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "question_regist";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";
	}
}
