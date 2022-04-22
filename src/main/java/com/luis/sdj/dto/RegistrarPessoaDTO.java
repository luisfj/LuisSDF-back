package com.luis.sdj.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

import com.luis.sdj.annotation.UniqueCpfValidation;
import com.luis.sdj.model.Pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
@UniqueCpfValidation
@NoArgsConstructor
public class RegistrarPessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "Nome deve ser informado")
	@Length(min = 3, max = 255, message = "Nome deve ter entre {min} e {max} caracteres")
	private String nome;
	private String sexo;
	@Email(regexp=".*@.*\\..*", message = "Email inválido")
	private String email;
	@NotNull(message = "Data de nascimento deve ser informada")
	private Date dataNascimento;
	private String naturalidade;
	private String nacionalidade;
	@CPF(message = "Cpf inválido")
	@NotNull(message = "Cpf deve ser informado")	
	@Pattern(regexp = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}", message = "Cpf em formato inválido, usar o padrão 999.999.999-99")
	private String cpf;
	
	public RegistrarPessoaDTO(Pessoa pessoa) {
		BeanUtils.copyProperties(pessoa, this);
	}
}
