package com.example.patientinformationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class PatientInformationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientInformationServiceApplication.class, args);
    }

}
