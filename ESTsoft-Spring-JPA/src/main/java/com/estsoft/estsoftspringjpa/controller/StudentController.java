package com.estsoft.estsoftspringjpa.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringjpa.model.Student;
import com.estsoft.estsoftspringjpa.repository.StudentJdbcRepository;
import com.estsoft.estsoftspringjpa.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentJdbcRepository studentJdbcRepository;
	@Autowired
	private StudentService studentService;

	@GetMapping("/student/count")
	public Integer countOfStudent() {
		return studentService.countOfStudent();
	}

	@GetMapping("/student/name/list")
	public List<String> getListOfStudentName() {
		return studentService.getListOfStudentName();
	}

	/**
	 * curl -X PUT "http://localhost:8080/student/regist?name=이지아&age=29"
	 *
	 * curl -X PUT -G --data-urlencode "name=김영수" --data-urlencode "age=28" http://localhost:8080/student/regist
	 *
	 * requestBody
	 * curl -X PUT "http://localhost:8080/student/regist" -d '{ "name":"김영수", "age":"28"}'
	 * @param params
	 */
	@PutMapping("/student/regist")
	public void registStudent(@RequestParam Map<String, Object> params) {
		studentService.registStudent(params);
	}

	@GetMapping("/student/{studentId}")
	public Map<String, Object> getListOfStudentName(@PathVariable Integer studentId) {
		return studentService.getStudent(studentId);
	}

	@PutMapping("/student/regist2")
	public void registStudent(@RequestBody Student student) {
		studentService.registStudent(student);
	}

	@GetMapping("/student/list")
	public List<Student> getListOfStudent() {
		return studentService.getListOfStudent();
	}

	@GetMapping("/student/search")
	public List<Student> searchStudent(@RequestParam String name) {
		return studentService.findStudents(name);
	}

	@GetMapping("/student/search/{studentId}")
	public Optional<Student> getStudent(@PathVariable Integer studentId) {
		return studentService.findStudent(studentId);
	}
}
