package com.example.simpleBoard.answer;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.simpleBoard.question.Question;
import com.example.simpleBoard.question.QuestionForm;
import com.example.simpleBoard.question.QuestionService;
import com.example.simpleBoard.user.SiteUser;
import com.example.simpleBoard.user.UserSecurityService;
import com.example.simpleBoard.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final UserService userService;
	private final QuestionService questionService;
	private final AnswerService answerService;

	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm,
			BindingResult bindingResult, Principal principal) {
		Question question = questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		if(bindingResult.hasErrors()) {
			Question q = questionService.getQuestion(id);
			model.addAttribute("question", q);
			return "question_detail";
		}
		this.answerService.create(question, answerForm.getContent(), siteUser);
		return "redirect:/question/detail/" + id;
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}/{q}")
	public String questionModify(AnswerForm answerform, @PathVariable("id") Integer id, Principal principal) {
		Answer answer = this.answerService.getAnswer(id);
		if(!answer.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		}
		answerform.setContent(answer.getContent());
		
		return "answer_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}/{q}")
	public String questionModify(@Valid AnswerForm answerform, BindingResult bindingResult, @PathVariable("id") Integer id, @PathVariable("q") Integer q, Principal principal) {
		if(bindingResult.hasErrors()) {
			return "answer_form";
		}
		
		Answer answer = this.answerService.getAnswer(id);
		if(!answer.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		}
		this.answerService.modify(answer, answerform.getContent());
		
		
		return String.format("redirect:/question/detail/%s", q);
	}
	
	@GetMapping("/delete/{id}/{q}")
	public String questionDelete(@PathVariable("id") Integer id, @PathVariable("q") Integer q) {
		this.answerService.delete(id);
		return String.format("redirect:/question/detail/%s", q);
	}
	
	
}
