package com.example;

import com.example.employee.EmployeeService;
import com.example.employee.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void employeeServiceTest() {
        log.info("Inserting employee -> {}", employeeService.save(
                Employee.builder().firstName("Job").lastName("Jacob").build()));
        log.info("All employees -> {}", employeeService.findAll());
    }
}
