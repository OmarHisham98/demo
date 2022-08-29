package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Student")  //for hibernate--> default name is the class name, but just to clarify name ="Student"
@Table  // for the table in database, define unique constraints here
public class Student {

    @Id         // to signify that the id is our primary key in the database table (students)
    @SequenceGenerator(                             // this sequence is for the id generated for the students
            name ="student_sequence",
            sequenceName="student_sequence",
            allocationSize= 1                       //this is the increment value of the id, the start value is default=(1) since it isn't identified here
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient   //used to ignore a field to not persist in database in JPA,means there is no need to be a column in the database
    private Integer age;

    public Student() {
    }

    // to specify specific attributes for each column in the table eg:name, use the annotation @Column
    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
