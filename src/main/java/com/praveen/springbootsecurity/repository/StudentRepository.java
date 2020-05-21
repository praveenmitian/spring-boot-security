package com.praveen.springbootsecurity.repository;


import com.praveen.springbootsecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
}
