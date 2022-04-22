package com.luis.sdj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.luis.sdj.dto.ExibirPessoaDTO;
import com.luis.sdj.dto.RegistrarPessoaDTO;
import com.luis.sdj.model.Pessoa;
import com.luis.sdj.repository.PessoaRepository;

@Component
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	PessoaRepository repository;
	
	@Override
	public Optional<Pessoa> findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
	
	@Override
	public ExibirPessoaDTO findById(Long id) {
		Optional<Pessoa> pessoa = repository.findById(id);
		if(!pessoa.isPresent())
			return null;
		return new ExibirPessoaDTO(pessoa.get());
	}

	@Override
	public List<ExibirPessoaDTO> findAll(Integer pagina, Integer registros, String ordenarPor, String ordenacao) {
		Pageable pageable = PageRequest.of(pagina, registros, ordenacao.equals("ASC") ? Sort.by(ordenarPor).ascending() : Sort.by(ordenarPor).descending());
		
		return repository.findAll(pageable).stream().map(ExibirPessoaDTO::new).collect(Collectors.toList());
	}

	@Override
	public ExibirPessoaDTO save(RegistrarPessoaDTO pessoa) {
		Pessoa p = new Pessoa();
		BeanUtils.copyProperties(pessoa, p);				
		return new ExibirPessoaDTO(repository.save(p));
	}

	@Override
	public ExibirPessoaDTO update(RegistrarPessoaDTO pessoa) {		
		Pessoa p = repository.getById(pessoa.getId());		
		BeanUtils.copyProperties(pessoa, p);
		return new ExibirPessoaDTO(repository.save(p));
	}

	@Override
	public boolean delete(Long id) {
		Optional<Pessoa> pessoa = repository.findById(id);
		
		if(!pessoa.isPresent()) 
			return false;
		
		repository.delete(pessoa.get());
		return true;
	}
	

}
