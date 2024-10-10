package com.estsoft.estsoftspringmybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import com.estsoft.estsoftspringmybatis.model.dto.LectureCourseDetail;
import com.estsoft.estsoftspringmybatis.model.dto.LectureCourseInfo;

@Mapper
public interface LectureMapper {

	@Transactional
	List<LectureCourseInfo> selectLectureCourseInfos();

	List<LectureCourseDetail> selectLectureCourseDetails(Map<String, Object> params);
}
