package com.estsoft.estsoftspringdemoproject.interf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * interface 타입으로 의존성 주입(DI) 할 때
 */
@Service
public class InterDependencyService {
	private final Inter inter;

	// Interface 타입으로 의존성 주입(DI)할 때 구현체를 지정하는 2가지 방법
	// 단, interface의 구현체가 하나일 경우에는 구현체를 지정하지 않아도 DI 가능
	// 1. @Qualifier("빈 이름(구현체) 지정")	ex) @Qualifier("InterImplA")
	// 2. Primary
	public InterDependencyService(/*@Qualifier("interImplA")*/ Inter inter) {
		this.inter = inter;
	}

	public void printMethod() {
		inter.method();
	}
}
