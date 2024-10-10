package com.estsoft.estsoftspringmybatis.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.estsoft.estsoftspringmybatis.model.dto.Instructor;

@Mapper
public interface InstructorMapper {
	Instructor selectInstructorByName(String name);

	Instructor selectInstructorById(Long id);

	int insertInstructor(Map<String, Object> params);
}
