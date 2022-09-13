package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration      //to make it a config. file
@EnableSwagger2
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

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Student API",
                "test API",
                "1.0",
                "http://google.com",
                new Contact("omar","haha","lb7@gm.com"),
                "license",
                "http://youtube.com",
                Collections.emptyList());
    }
}
