package com.luis.sdj.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ValidationErrorResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Violation> violations = new ArrayList<>();

}
