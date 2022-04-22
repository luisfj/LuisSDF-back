package com.luis.sdj.resource;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.sdj.dto.ExibirPessoaDTO;
import com.luis.sdj.dto.RegistrarPessoaDTO;
import com.luis.sdj.service.PessoaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	PessoaService service;
	
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Listar todas as pessoas registradas",
    	authorizations = { @Authorization(value="basicAuth") })
	public ResponseEntity<List<ExibirPessoaDTO>> listarPaginando(
			@RequestParam(value="pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value="registros", defaultValue = "10") Integer registros,
			@RequestParam(value="ordenarPor", defaultValue = "id") String ordenarPor,
			@RequestParam(value="ordem", defaultValue = "ASC") String ordem
			) {
		
		return new ResponseEntity<>(service.findAll(pagina, registros, ordenarPor, ordenarPor), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	@ApiOperation(value = "Retorna a pessoa com o id referente",
    	authorizations = { @Authorization(value="basicAuth") })
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<ExibirPessoaDTO> listarPaginando(
			@NotNull @PathVariable("id") Long id
			) {
		
		ExibirPessoaDTO pessoaDto = service.findById(id);
		if(pessoaDto == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(pessoaDto, HttpStatus.OK);
	}
	
	
	@PostMapping(produces = "application/json")
	@ApiOperation(value = "Inserir uma nova pessoa",
		authorizations = { @Authorization(value="basicAuth") })
	public ResponseEntity<ExibirPessoaDTO> salvar(@RequestBody @Valid RegistrarPessoaDTO pessoaDto) {
		pessoaDto.setId(null);
		return new ResponseEntity<>(service.save(pessoaDto), HttpStatus.CREATED);
	}
	
	@PutMapping(produces = "application/json")
	@ApiOperation(value = "Atualizar uma pessoa",
		authorizations = { @Authorization(value="basicAuth") })	
	public ResponseEntity<ExibirPessoaDTO> atualizar(@RequestBody @Valid RegistrarPessoaDTO pessoaDto) {		
		return new ResponseEntity<>(service.update(pessoaDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(
			value = "Remover uma pessoa",
			authorizations = { @Authorization(value="basicAuth") })
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Long> remover(@NotNull @PathVariable("id") Long id) {
		var isRemoved = service.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
	}
		
}
