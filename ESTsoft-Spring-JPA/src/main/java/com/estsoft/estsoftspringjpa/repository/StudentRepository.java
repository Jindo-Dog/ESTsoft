package com.estsoft.estsoftspringjpa.repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.estsoft.estsoftspringjpa.model.Student;

public interface StudentRepository {
	int countOfStudents();

	List<String> selectListOfStudentName();

	int insertStudent(Map<String, Object> params);

	Map<String, Object> getStudent(int id);

	Student getStudentById(int id);

	int insertStudent(Student student);

	List<Student> selectListOfStudent();

	List<Student> findStudents(String name);

	Optional<Student> selectStudentById(Integer studentId);
}
