package com.estsoft.estsoftspringdemoproject.interf;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class InterImplB implements Inter {
	@Override
	public void method() {
		System.out.println("Hi B");
	}
}
