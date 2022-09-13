package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter @Getter @NoArgsConstructor
@Entity(name = "Student")  //for hibernate--> default name is the class name, but just to clarify name ="Student"
@Table  // for the table in database, define unique constraints here
@Data
public class Student {

    @Id         // to signify that the id is our primary key in the database table (students)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient   //used to ignore a field to not persist in database in JPA,means there is no need to be a column in the database
    private Integer age;


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

    public void setDob(LocalDate dob) {
        this.dob = dob;
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
