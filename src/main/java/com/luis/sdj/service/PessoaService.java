package com.luis.sdj.service;

import java.util.List;
import java.util.Optional;

import com.luis.sdj.dto.ExibirPessoaDTO;
import com.luis.sdj.dto.RegistrarPessoaDTO;
import com.luis.sdj.model.Pessoa;

public interface PessoaService {

	Optional<Pessoa> findByCpf(String cpf);
	
	ExibirPessoaDTO findById(Long id);
	
	List<ExibirPessoaDTO> findAll(Integer pagina, Integer registros, String ordenarPor, String ordenacao);
	
	ExibirPessoaDTO save(RegistrarPessoaDTO pessoa);
	
	ExibirPessoaDTO update(RegistrarPessoaDTO pessoa);
	
	boolean delete(Long id);
}
