package com.example;

import com.example.employee.EmployeeService;
import com.example.employee.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class EmployeeTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void employeeServiceTest() {
        logger.info("Inserting employee -> {}", employeeService.save(Employee.builder().firstName("Job").lastName("Jacob").build()));
        logger.info("All employees -> {}", employeeService.findAll());
    }
}
