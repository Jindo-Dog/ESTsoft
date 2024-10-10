package com.estsoft.estsoftspringmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import com.estsoft.estsoftspringmybatis.model.dto.LectureCourseDetail;
import com.estsoft.estsoftspringmybatis.model.dto.LectureCourseInfo;
import com.estsoft.estsoftspringmybatis.repository.LectureMapper;
import com.estsoft.estsoftspringmybatis.repository.StudentMapper;

@Service
public class LectureService {
	@Autowired
	private LectureMapper lectureMapper;

	@Autowired
	private StudentMapper studentMapper;

	public List<LectureCourseInfo> getLectureCourseInfo() {
		return lectureMapper.selectLectureCourseInfos();
	}

	public List<LectureCourseDetail> getLectureCourseDetails(Map<String, Object> params) {
		List<LectureCourseDetail> list = lectureMapper.selectLectureCourseDetails(params);
		//복호화도 하고
		// 다른비지니스처리르 100개정도한다면
		// => 세분화 대상
		// java convetion rule & code style
		return lectureMapper.selectLectureCourseDetails(params);
	}

	// toy project -> 2개의 시스템은 만든다 하면 mybatis, JPA, mybatis+JPA /

	@Transactional
	public void applyLectureCourse(Map<String, Object> params) {
		/*
		begin transaction
		insert into lecture_applicants(.......)
		---
		update student set lecture_count = lecture_count++ where id = 1
		 */

		// lectureMapper.saveLectureCourse()
		// 	seudentMapper.insertStudent(params)
	}
}
