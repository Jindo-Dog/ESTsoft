package com.estsoft.estsoftspringdemoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringdemoproject.ioc.Member;
import com.estsoft.estsoftspringdemoproject.service.HelloService;

@RestController
public class HelloController {    // 콩 모양 아이콘: 스프링이 관리하는 객체라는 의미
	// @Autowired
	private HelloService service;

	// 최근에는 Autowired 보다 생성자 주입 방식을 더 많이 사용한다
	public HelloController(HelloService service) {    // 생성자 주입(Dependency Injection) - DI 사용해서 spring에게 제어권 맡김
		this.service = service;
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "param", defaultValue = "Spring") String param) {
		// 객체 직접 생성, 호출
		/*HelloService service = new HelloService();
		return service.printHello(param);*/

		// 	spring에게 제어권 맡기기(DI 활용)
		Member member = new Member(1, "sungteon", "address");    // 기능을 가진 것이 아니기 때문에 단순히 선언해서 사용한다(@Service 사용 x)
		return service.printHello(param);
	}
}