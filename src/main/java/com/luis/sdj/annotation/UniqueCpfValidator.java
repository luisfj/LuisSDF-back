package com.luis.sdj.annotation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.luis.sdj.dto.RegistrarPessoaDTO;
import com.luis.sdj.model.Pessoa;
import com.luis.sdj.service.PessoaService;
import com.luis.sdj.util.ServiceUtils;



public class UniqueCpfValidator implements ConstraintValidator<UniqueCpfValidation, RegistrarPessoaDTO>
{	
	@Autowired PessoaService service;
	
	@Override
	 public void initialize(UniqueCpfValidation constraintAnnotation) {
		service = ServiceUtils.getPessoaService();
		
	 }
	
    public boolean isValid(RegistrarPessoaDTO pessoa, ConstraintValidatorContext cxt) {
    	Optional<Pessoa> pessoaOpt = service.findByCpf(pessoa.getCpf());
    	
    	return (pessoa.getId() != null && pessoa.getId() > 0 && pessoaOpt.isPresent() && pessoaOpt.get().getId().equals(pessoa.getId()))
    			|| ((pessoa.getId() == null || pessoa.getId() <= 0) && !pessoaOpt.isPresent());
    }
}