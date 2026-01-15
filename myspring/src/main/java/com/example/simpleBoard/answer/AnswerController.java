package com.example.simpleBoard.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.simpleBoard.question.Question;
import com.example.simpleBoard.question.QuestionForm;
import com.example.simpleBoard.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			Question q = questionService.getQuestion(id);
			model.addAttribute("question", q);
			return "question_detail";
		}
		Question question = questionService.getQuestion(id);
		this.answerService.create(question, answerForm.getContent());
		return "redirect:/question/detail/" + id;
	}
	
	
}
