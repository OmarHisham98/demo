package com.example.demo.student;

//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student") //instead of going to localhost 8080 it is going to go to localhost:8080/postgres/api/v1/student
public class    StudentController {

    private final StudentService studentService;

    @Autowired  //the upper private final StudentService is autowired to resolve dependency injection in the below method,that's why we used @Service (like @Component or @Bean, but @Service is better for readability) over the StudentService class
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path="/")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(path="/{studentId}")
    @Operation(summary = "gets Student by ID",description = "Pls provide an ID")
    public Student getStudent(@Parameter(name="gets a single student with the specified ID", required=true) @PathVariable long studentId){
        return studentService.getStudent( studentId);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){//the annotation deserializes the json sent from a client-side controller into java type
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId")Long studentId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String email){
        studentService.updateStudent(studentId,name,email);
    }
}
