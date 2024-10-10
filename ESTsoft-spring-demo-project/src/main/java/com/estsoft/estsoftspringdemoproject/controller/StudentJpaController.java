package com.estsoft.estsoftspringdemoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringdemoproject.entity.Student;
import com.estsoft.estsoftspringdemoproject.repository.StudentRepository;

@RestController
public class StudentJpaController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/student/{id}")
	public String getStudentName(@PathVariable(name = "id") Long id) {
		return studentRepository.findById(id).get().getName();
	}

	@PostMapping("/student")
	public Long saveStudent(
		@RequestParam(name = "name") String name,
		@RequestParam(name = "age") Integer age,
		@RequestParam(name = "desc", required = false) String desc) {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setDesc(desc);
		studentRepository.save(student);

		return student.getId();
	}
}
