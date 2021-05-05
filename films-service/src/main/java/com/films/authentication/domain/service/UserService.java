package com.films.authentication.domain.service;

import com.films.authentication.domain.model.User;

public interface UserService {

	User createUser(User user);

    Iterable<User> getAccounts();
}
