package com.luis.sdj.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicResource {

	@GetMapping(path="/source")
	public String getSource() {
		return "https://github.com/luisfj";	
	}
}
