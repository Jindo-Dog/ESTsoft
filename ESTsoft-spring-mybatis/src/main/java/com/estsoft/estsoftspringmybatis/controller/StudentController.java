package com.estsoft.estsoftspringmybatis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estsoft.estsoftspringmybatis.model.dto.Student;
import com.estsoft.estsoftspringmybatis.service.StudentService;

/**
 * 요청을 담당할 컨트롤러이다라고 스프링한테 알려주기 위한것 ==> @RestController
 */
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	// gradle multi module -> (?)
	// spring이 관리할 대상들은 어떻게 인지하는가?
	// 1. @SpringBootApplication class(main)와 sibling, 그 하위 level에 존재하는 클래스들이 1차대상.
	// 이 규칙을 벗어나고 싶다면, 우리가 명시적으로 스프링한테 관리해야될 클래스들의 정보를 알려줘야 한다.
	// 2. CompoentScan,
	// 3. stereotype -> @Service, @Repository, @Controller, @RestController, @Component. ->
	// 4. @Entity도 추가적으로 스프링한테 관리해달라는 것.
	//
	// DI 여러가지 방식이 있을 수 있다
	// 1. setter method를 통해서 DI 처리하기 -
	// 2. 생성자를 통해서 DI 처리하기 -
	// 3. autwired annotation을 이용해서 처리하기 -
	// -> 각각의 장단점이 있다. 순환 참조. circular reference. -> local개발시 겪을수 있는 문제

	/*
	service class -> class 설계를 잘하는 게 중요
	StudentService -> LectureService
	LectureService -> StudentService
	==> 방지 or 사전인지할 수 있는 좋은 방안이 생성자 기반의 DI 처리하기
	-> bootRun(application Run) 이 시점에 순환 참조된 것을 사전인해해서 방지할 수 있음
	 */

	/**
	 * curl -X GET "http://localhost:8080/student
	 * @param name
	 * @return
	 */
	@GetMapping("/student")
	public Student getStudent(@RequestParam(required = false) String name) {
		return studentService.getStudentByName(name);
	}

	@PostMapping("/student")
	public ResponseEntity<String> registStudent(@RequestBody Map<String, Object> params) {
		return ResponseEntity.ok().body(studentService.saveStudent(params));
	}
}
