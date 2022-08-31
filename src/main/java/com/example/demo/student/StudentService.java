package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.
                findOneByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken please insert another email");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student "+ studentId +"does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional   //to avoid writing SQL
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                        "Student "+ studentId +"does not exist"));
        if(name!=null &&
                name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null &&
                email.length()>0 &&
                !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional =
                    studentRepository.findOneByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email isn't available");
            }
            student.setEmail(email);
        }

    }
}
