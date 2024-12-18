package com.example.securitydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securitydemo.model.Student;



public interface StudentRepository extends JpaRepository<Student, Long> {
}