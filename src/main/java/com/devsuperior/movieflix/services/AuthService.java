package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User getAuthenticatedUser() {
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			Optional<User> userOptional = userRepository.findByEmail(email);
			return userOptional.get();
		} catch (Exception e) {
			throw new UnauthorizedException("Unauthorized");
		}
	}

	public void validSelfOrAdmin(Long userId) {
		User authenticatedUser = getAuthenticatedUser();
		if (!authenticatedUser.getId().equals(userId) && !authenticatedUser.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Forbidden");
		}
	}
}
