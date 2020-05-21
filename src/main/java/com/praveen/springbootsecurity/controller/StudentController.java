package com.praveen.springbootsecurity.controller;

import com.praveen.springbootsecurity.model.Student;
import com.praveen.springbootsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "{studentId}")
    //@RequestMapping(value = "{studentId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
                    return studentService.getAllStudents().stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Student " + studentId + " does not exists"
                ));
    }
}
