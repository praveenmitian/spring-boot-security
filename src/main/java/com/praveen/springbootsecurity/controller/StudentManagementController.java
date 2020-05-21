package com.praveen.springbootsecurity.controller;

import com.praveen.springbootsecurity.model.Student;
import com.praveen.springbootsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    //@RequestMapping(value = "{studentId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('course:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(studentService.saveStudent(student));
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('course:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('course:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println(studentId);
        Student student1 = studentService.getStudentById(studentId);
        student1.setStudentName(student.getStudentName());
        System.out.println(studentService.saveStudent(student1));
    }
}
