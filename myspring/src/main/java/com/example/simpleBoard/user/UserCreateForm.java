package com.example.simpleBoard.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	
	@NotEmpty(message="User Name을 입력해주세요.")
	@Size(min=3, max=25, message="min 3, max25")
	private String username;
	
	@NotEmpty(message="Password를 입력해주세요.")
	private String password;
	
	@NotEmpty(message="Password Confirm을 입력해주세요.")
	private String password2;
	
	@NotEmpty(message="Email을 입력해주세요.")
	@Email
	private String email;
}
