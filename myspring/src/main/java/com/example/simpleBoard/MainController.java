package com.example.simpleBoard;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.simpleBoard.user.SiteUser;
import com.example.simpleBoard.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final UserService userService;
	
	@GetMapping("/")
	public String root(@AuthenticationPrincipal User userDetails, Model model) {
		if(userDetails != null) {
			SiteUser user = userService.getUser(userDetails.getUsername());
			model.addAttribute("profileImage", user.getImageUrl());
		}
		return "index";
	}
	
	@GetMapping("/boxoffice")
	public String movie() {
		
		return "movie_boxoffice";
	}
}
