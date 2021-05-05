package com.films.authentication.domain.repository;

import com.films.authentication.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
