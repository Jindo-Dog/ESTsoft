package com.estsoft.estsoftspringdemoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estsoft.estsoftspringdemoproject.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
