package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration      //to make it a config. file
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
          Student omar = new Student(
                            "Omar",
                            "lb7omar@gg.com",
                            LocalDate.of(1998,Month.OCTOBER ,30));
          Student ahmed = new Student(
                "Ahmed",
                "ahmed@gg.com",
                LocalDate.of(1999,Month.OCTOBER ,28));
          repository.saveAll(
                  List.of(omar,ahmed)
          );

        };
    }
}
