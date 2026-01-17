package com.example.simpleBoard.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRpository extends JpaRepository<SitUser, Long> {
	Optional<SitUser> findByUsername(String username);
}
