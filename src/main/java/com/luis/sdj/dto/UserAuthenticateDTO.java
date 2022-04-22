package com.luis.sdj.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
@NoArgsConstructor
public class UserAuthenticateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Usuário deve ser informado")
	private String usuario;
	@NotNull(message = "Senha deve ser informada")
	private String senha;
}
