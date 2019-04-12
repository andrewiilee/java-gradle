package com.example;

import com.example.employee.EmployeeService;
import com.example.employee.entity.Employee;
import com.example.student.dao.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final StudentDAO studentDAO;
    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("All students -> {}", studentDAO.findAll());
        logger.info("Inserting employee -> {}", employeeService.save(Employee.builder().firstName("Job").lastName("Jacob").build()));
        logger.info("All employees -> {}", employeeService.findAll());
    }
}
