package com.estsoft.estsoftspringjpa.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringjpa.model.Student;
import com.estsoft.estsoftspringjpa.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	// @Qualifier("studentNamedParameterJdbcRepository")
	@Qualifier("studentJdbcRepository")
	private StudentRepository studentRepository;

	public Integer countOfStudent() {
		return studentRepository.countOfStudents();
	}

	public List<String> getListOfStudentName() {
		return studentRepository.selectListOfStudentName();
	}

	public void registStudent(Map<String, Object> params) {
		studentRepository.insertStudent(params);
	}

	public Map<String, Object> getStudent(int id) {
		return studentRepository.getStudent(id);
	}

	public void registStudent(Student student) {
		studentRepository.insertStudent(student);
	}

	public List<Student> getListOfStudent() {
		return studentRepository.selectListOfStudent();
	}

	public List<Student> findStudents(String name) {
		return studentRepository.findStudents(name);
	}

	public Optional<Student> findStudent(Integer studentId) {
		return studentRepository.selectStudentById(studentId);
	}
}
