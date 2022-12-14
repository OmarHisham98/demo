package com.example.demo.student;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Setter @Getter @NoArgsConstructor
@Entity(name = "Student")  //for hibernate--> default name is the class name, but just to clarify name ="Student"
@Table  // for the table in database, define unique constraints here
@AllArgsConstructor
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

    public Integer getAge(){
        return Period.between(this.dob,LocalDate.now()).getYears();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
