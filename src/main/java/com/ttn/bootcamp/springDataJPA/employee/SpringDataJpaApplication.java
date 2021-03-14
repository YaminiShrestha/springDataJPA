package com.ttn.bootcamp.springDataJPA.employee;

import com.ttn.bootcamp.springDataJPA.employee.entities.Employee;
import com.ttn.bootcamp.springDataJPA.employee.respository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);


    }


}
