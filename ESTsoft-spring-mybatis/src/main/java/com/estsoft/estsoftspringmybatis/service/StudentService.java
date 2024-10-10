package com.estsoft.estsoftspringmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.estsoft.estsoftspringmybatis.model.dto.Student;
import com.estsoft.estsoftspringmybatis.repository.StudentMapper;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;

	public Student getStudentByName(String name) {
		return studentMapper.selectStudentByName(name);
	}

	public String saveStudent(Map<String, Object> params) {
		int result = studentMapper.insertStudent(params);

		return result == 1 ? "성공적으로 저장하였습니다." : "요청하신 학생정보 등록에 실패하였습니다.";
	}
}
