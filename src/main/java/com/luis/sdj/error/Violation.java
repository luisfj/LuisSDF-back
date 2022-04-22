package com.luis.sdj.error;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Violation implements Serializable {
	private static final long serialVersionUID = 1L;

	  private final String fieldName;

	  private final String message;
	  
}
