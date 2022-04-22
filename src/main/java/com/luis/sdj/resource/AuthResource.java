package com.luis.sdj.resource;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luis.sdj.dto.UserAuthenticateDTO;

@RestController
public class AuthResource {

	@PostMapping(path="/user/authenticate")
	public ResponseEntity<UserAuthenticateDTO> autenticar(@RequestBody @Valid UserAuthenticateDTO userDto) {
		if(userDto.getUsuario().equals("user") && userDto.getSenha().equals("pass"))
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
