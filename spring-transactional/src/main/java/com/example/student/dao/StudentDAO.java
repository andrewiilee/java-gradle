package com.example.student.dao;

import com.example.student.pojo.Student;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentDAO {
    @Qualifier("studentJdbcTemplate")
    private final NamedParameterJdbcTemplate namedParamJdbcTemplate;

    public List<Student> findAll() {
        return namedParamJdbcTemplate.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
    }

    public Student findById(int id) {
        return namedParamJdbcTemplate.queryForObject("select * from student where id=:id",
            new MapSqlParameterSource().addValue("id", id), new BeanPropertyRowMapper<>(Student.class));
    }

    public int deleteById(int id) {
        return namedParamJdbcTemplate.update("delete from student where id=:id",
            new MapSqlParameterSource().addValue("id", id));
    }

    public int insert(Student student) {
        return namedParamJdbcTemplate.update(
            "insert into student (id, name, passport_number) values(:id,  :name, :passportNumber)",
            new BeanPropertySqlParameterSource(student));
    }

    public int update(Student student) {
        return namedParamJdbcTemplate.update(
            "update student set name = :name, passport_number = :passportNumber where id = :id",
            new BeanPropertySqlParameterSource(student));
    }

}
