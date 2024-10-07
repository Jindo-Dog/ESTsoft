package com.estsoft.estsoftspringdemoproject.controller;

import com.estsoft.example.HiService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RestController = @Controller + @ResponseBody	-> 문자열 리턴
// @ResponseBody
@Controller        // -> view 리턴
public class SampleController {

	/**
	 * HiService 빈이 컴포넌트 스캔의 대상 아니라면 DI 불가
	 */
	/*private HiService hiService;

	public SampleController(HiService hiService) {
		this.hiService = hiService;
	}*/
	@GetMapping("/hello2")
	public String hello2() {
		// view를 리턴한다
		return "hi.html";    // resources/templates/hi.html 호출
	}
}
