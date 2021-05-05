package com.films.authentication.api;

import com.films.authentication.domain.model.User;
import com.films.authentication.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/accounts")
    public Iterable<User> getAccount( ) {
        return userService.getAccounts();
    }
}
