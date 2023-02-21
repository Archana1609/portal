package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API {
    private String studentName = "IM NEO";
	@GetMapping("/")
	public String getName() {
		return "Welcome "+studentName+"!";
	}
	
	
}
