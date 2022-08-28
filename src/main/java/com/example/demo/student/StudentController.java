package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student") //instead of going to localhost 8080 it is going to go to localhost8080/api/v1/student
public class StudentController {

    private final StudentService studentService;

    @Autowired  //the upper private final StudentService is autowired to resolve deoendency injection in the below method,that's why we used @Service (like @Component or @Bean, but @Service is better for readability) over the StudentService class
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
