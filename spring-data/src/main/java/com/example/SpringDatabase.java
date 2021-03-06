package com.example;

import java.util.Arrays;
import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class SpringDatabase {
    @Qualifier("employeeJdbcTemplate")
    private final JdbcTemplate employeeJdbc;

    @Qualifier("studentJdbcTemplate")
    private final JdbcTemplate studentJdbc;

    @PostConstruct
    private void initDb() {
        log.info("****** Creating table: {}, and Inserting test data ******", "Employee");

        String employeeSQL[] = {
            "drop table employee if exists",
            "create table employee(id serial,first_name varchar(255),last_name varchar(255))",
            "insert into employee(first_name, last_name) values('Sauda  ','Morwen')",
            "insert into employee(first_name, last_name) values('Mikael','Luksa')"
        };

        executeSql(employeeSQL, employeeJdbc);

        log.info("****** Fetching from table: {} ******", "Employee");
        employeeJdbc.query("select id,first_name,last_name from employee",
            (rs, i) -> {
                log.info("id: {}, first_name: {}, last_name: {}",
                    rs.getString("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"));
                return null;
            });

        String studentSQL[] = {
            "drop table student if exists",
            "create table student(id integer,name varchar(255),passport_number varchar(255), primary key(id))",
            "insert into student(id, name, passport_number) values(99901, 'Freyja','E1234567')",
            "insert into student(id, name, passport_number) values(88802, 'Ronit','A1234568')"
        };

        executeSql(studentSQL, studentJdbc);

    }

    private void executeSql(String sqls[], JdbcTemplate jdbcTemplate) {
        Arrays.stream(sqls).forEach(sql -> {
            log.info((sql));
            jdbcTemplate.execute(sql);
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDatabase.class, args);
    }
}
