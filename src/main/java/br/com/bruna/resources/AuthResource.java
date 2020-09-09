package br.com.bruna.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruna.domain.dto.EmailDTO;
import br.com.bruna.security.JWTUtil;
import br.com.bruna.security.UserSs;
import br.com.bruna.services.AuthService;
import br.com.bruna.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	@Autowired
	private AuthService authService;

	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping(value = "/refresh-token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response){
		UserSs user = UserService.authenticated();
		String token = jwtUtil.generationToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/forgot")
	public ResponseEntity<Void> forgotPassword(@RequestBody @Valid EmailDTO objDto){
		authService.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}
}
