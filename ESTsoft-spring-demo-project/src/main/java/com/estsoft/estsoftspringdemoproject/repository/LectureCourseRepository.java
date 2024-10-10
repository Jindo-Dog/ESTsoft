package com.estsoft.estsoftspringdemoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estsoft.estsoftspringdemoproject.entity.LectureCourse;

public interface LectureCourseRepository extends JpaRepository<LectureCourse, Long> {
}
