package com.films.authentication.domain.service;

import com.films.authentication.domain.model.Role;
import com.films.authentication.domain.model.User;
import com.films.authentication.domain.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public User createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.addRoles(Arrays.asList(Role.ROLE_USER));
		return userRepository.save(user);
	}


	@Override public Iterable<User> getAccounts() {
		return userRepository.findAll();
	}
}
