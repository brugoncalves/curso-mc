package br.com.bruna.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.bruna.security.UserSs;

public class UserService {

	public static UserSs authenticated() {
		try {
			return (UserSs) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) {
			return null;
		}
	}
}
