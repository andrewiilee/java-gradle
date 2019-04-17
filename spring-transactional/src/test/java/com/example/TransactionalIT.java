package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.employee.EmployeeService;
import com.example.employee.entity.Employee;
import com.example.student.dao.StudentDAO;
import com.example.student.pojo.Student;
import com.example.transactional.TransactionalService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("default")
public class TransactionalIT {

    //one idea is to start the database and use prod profile
    //turn one of the database off. When attempting to save to 2 databases, if the 2nd one fails we should expect
    //the first database to rollback this would be an integration test at this point
    //TODO create readme to demonstrate SQL creation, H2, namedParamJdbcTemplate power (no more position queries)
    //TODO write test to demonstrate transactional roll back with two datasource

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StudentDAO studentDAO;

    private Student student = Student.builder().id(10001).name("Transaction").passportNumber("TTT").build();
    private Employee employee = Employee.builder().firstName("Transaction").lastName("TTT").build();

    @Test
    public void transactionalService_should_rollBackStudent_WhenEmployeeDbFails() {
        studentDAO.deleteById(10001);
        try {
            transactionalService.saveStudentThenEmployee(student);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            assertThat(studentDAO.findAll().size()).isEqualTo(2);
        }
    }

    @Test
    public void transactionalService_should_rollBackEmployee_WhenStudentDbFails() {
        employeeService.deleteByFirstName("Transaction");
        try {
            transactionalService.saveEmployeeThenStudent(employee, student.toBuilder().id(99901).build());
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
            assertThat(employeeService.findAll().size()).isEqualTo(2);
        }
    }
}
