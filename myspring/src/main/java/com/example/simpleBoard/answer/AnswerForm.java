package com.example.simpleBoard.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	@NotEmpty(message="내용을 입력해주세요.")
	@Size(max=200)
	private String content;
}
