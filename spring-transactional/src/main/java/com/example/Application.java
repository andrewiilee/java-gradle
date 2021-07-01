package com.example;

import com.example.employee.EmployeeService;
import com.example.student.dao.StudentDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class Application implements CommandLineRunner {

    private final StudentDAO studentDAO;
    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("All students -> {}", studentDAO.findAll());
        log.info("All employees -> {}", employeeService.findAll());
    }
}
