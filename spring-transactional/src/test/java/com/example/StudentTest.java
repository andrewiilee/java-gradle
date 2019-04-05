package com.example;

import com.example.student.dao.StudentDAO;
import com.example.student.pojo.Student;
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
public class StudentTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void applicationTest() {
        logger.info("Student id 10001 -> {}", studentDAO.findById(10001));
        logger.info("Inserting student-> {}", studentDAO.insert(Student.builder().id(10010).name("John").passportNumber("A1234657").build()));
        logger.info("Update 10003 student -> {}", studentDAO.update(Student.builder().id(10001).name("Name-Updated").passportNumber("New-Passport").build()));
        studentDAO.deleteById(10002);
        logger.info("All students -> {}", studentDAO.findAll());
    }

    //TODO see if this can connect to a real sql by standing up an independent springboot h2 see 'https://www.baeldung.com/spring-jdbc-jdbctemplate'
    //TODO dev profile vs real profile so it can connect test vs real
    //TODO test transactional (see below for infrastructure)
    //TODO create another DAO with another sql to simulate two DAO write
    //TODO create readme to demonstrate SQL creation, H2, namedParamJdbcTemplate power (no more position queries)
}


