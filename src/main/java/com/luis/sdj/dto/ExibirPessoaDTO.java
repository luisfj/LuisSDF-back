package com.luis.sdj.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.luis.sdj.model.Pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
@NoArgsConstructor
public class ExibirPessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sexo;
	private String email;
	private String dataNascimento;
	private String naturalidade;
	private String nacionalidade;
	private String cpf;
	private Date createDate;
	private Date modifyDate;
	
	
	public ExibirPessoaDTO(Pessoa pessoa) {
		BeanUtils.copyProperties(pessoa, this);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		this.dataNascimento = sdf.format(pessoa.getDataNascimento());
	}
}
