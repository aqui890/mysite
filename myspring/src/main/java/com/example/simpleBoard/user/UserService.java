package com.example.simpleBoard.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRpository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public SitUser create(String username, String email, String password) {
		SitUser user = new SitUser();
		user.setUsername(username);
		user.setEmail(email); 
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
	}
}
