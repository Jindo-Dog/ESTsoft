package com.estsoft.estsoftspringdemoproject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class HelloService {
	public String printHello(String param) {
		return "Hello " + param;
	}
}
