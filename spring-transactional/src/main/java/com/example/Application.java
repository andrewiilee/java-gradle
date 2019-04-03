package com.example;

import com.example.dao.StudentDAO;
import com.example.pojo.Student;
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

    private final StudentDAO repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        logger.info("Student id 10001 -> {}", repository.findById(10001L));

        logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));

        logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

        repository.deleteById(10002L);

        logger.info("All users -> {}", repository.findAll());
    }
}
