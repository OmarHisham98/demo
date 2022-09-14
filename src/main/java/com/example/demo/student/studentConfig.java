package com.example.demo.student;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration      //to make it a config. file
//@EnableSwagger2
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
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Student API")
                        .description("test api for a student entity")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://google.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("github")
                        .url("https://github.com/OmarHisham98"));
    }


    //    @Bean
//    public Docket swaggerConfiguration(){
//        return new Docket(DocumentationType.)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example"))
//                .build()
//                .apiInfo(apiDetails());
//    }


//    private ApiInfo apiDetails(){
//        return new ApiInfo(
//                "Student API",
//                "test API",
//                "1.0",
//                "http://google.com",
//                new Contact("omar","haha","lb7@gm.com"),
//                "license",
//                "http://youtube.com",
//                Collections.emptyList());
//    }
}
