package com.films.authentication.domain.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	@Id
	 @NotEmpty
	@Size(min = 5, max = 15)
	private String username;

	@NotEmpty
	@Size(min = 5)
	private String password;

	@NotEmpty
	private String name;

	@NotEmpty
	private String email;

	private Set<Role> roles = new HashSet<>();

	public User () {
		roles.add(Role.ROLE_USER);
	}

	public User(String username, String password, String name, String email,Role role) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.roles=new HashSet<>();
		this.roles.add(role);
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void addRoles(Collection<Role> roles) {
		this.roles.addAll(roles);
	}
}
