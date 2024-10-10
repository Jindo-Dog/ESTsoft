package com.estsoft.estsoftspringdemoproject.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringdemoproject.entity.LectureCourse;
import com.estsoft.estsoftspringdemoproject.repository.LectureCourseRepository;

@RestController
public class LectureCourseController {
	@Autowired
	private LectureCourseRepository lectureCourseRepository;

	@PostMapping("/lecture/course")
	public void saveLectureCourse(
		@RequestParam(name = "title") String title,
		@RequestParam(name = "instructorId") Long instructorId,
		@RequestParam(name = "capacity") Integer capacity,
		@RequestParam(name = "from")
		@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
		@RequestParam(name = "to")
		@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to,
		@RequestParam(name = "desc", required = false) String desc

	) {
		LectureCourse entity = new LectureCourse();
		entity.setTitle(title);
		entity.setInstructorId(instructorId);
		entity.setCapacity(capacity);
		entity.setFrom(from);
		entity.setTo(to);
		entity.setDesc(desc);
		lectureCourseRepository.save(entity);
	}
}
