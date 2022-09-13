package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository     //to make this interface responsible for data access
public interface StudentRepository
        extends JpaRepository<Student,Long> {

        //SELECT * FROM student WHERE email=...
//        @Query("SELECT s FROM Student s WHERE s.email = ?1")
        Optional<Student> findOneByEmail(String email);

}
