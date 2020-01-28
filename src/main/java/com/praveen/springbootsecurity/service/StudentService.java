package com.praveen.springbootsecurity.service;

import com.praveen.springbootsecurity.model.Student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    Student saveStudent(Student product);

    void deleteStudent(Student id);
}
