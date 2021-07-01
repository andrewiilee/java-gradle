package com.example;

import com.example.student.dao.StudentDAO;
import com.example.student.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class StudentTest {

    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void sudentDAOTest() {
        log.info("Student id 10001 -> {}", studentDAO.findById(10001));
        log.info("Inserting student-> {}", studentDAO.insert(Student.builder().id(10010).name("John").passportNumber("A1234657").build()));
        log.info("Update 10003 student -> {}", studentDAO.update(Student.builder().id(10001).name("Name-Updated").passportNumber("New-Passport").build()));
        studentDAO.deleteById(10002);
        log.info("All students -> {}", studentDAO.findAll());
    }

}


