package com.luis.sdj.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luis.sdj.service.PessoaService;

@Component
public class ServiceUtils {
  private static ServiceUtils instance;

  @Autowired
  private PessoaService pessoaService;

  /* Post constructor */

  @PostConstruct
  public void fillInstance() {
    instance = this;
  }

  /*static methods */

  public static PessoaService getPessoaService() {
    return instance.pessoaService;
  }
}