package com.films.authentication.domain.service;

import com.films.authentication.domain.model.User;
import com.films.authentication.domain.repository.UserRepository;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            User user1 = user.get();
            Set<SimpleGrantedAuthority> grantedAuthorities = user1.getRoles()
                .stream()
        	  .map(role -> new SimpleGrantedAuthority(role.name()))
        	  .collect(Collectors.toSet());

            return new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(), grantedAuthorities);
        }
    }
}
