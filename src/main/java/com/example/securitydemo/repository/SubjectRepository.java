package com.example.securitydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securitydemo.model.Subject;



public interface SubjectRepository extends JpaRepository<Subject, Long> {
}