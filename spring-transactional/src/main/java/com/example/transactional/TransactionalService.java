package com.example.transactional;

import com.example.employee.EmployeeService;
import com.example.employee.entity.Employee;
import com.example.student.dao.StudentDAO;
import com.example.student.pojo.Student;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TransactionalService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EmployeeService employeeService;
    private StudentDAO studentDAO;

    @Transactional
    public void saveEmployeeThenStudent(Employee employee, Student student) {
        //99901 should trigger primary key violation
        saveEmployee(employee);
        saveStudent(student);
    }

    @Transactional("studentManager")
    public void saveStudentThenEmployee(Student student) {
        //null should trigger primary key violation
        saveStudent(student);
        saveEmployee(null);
    }

    private void saveStudent(Student student) {
        logger.info("Inserting student-> {}", studentDAO.insert(student));
    }

    private void saveEmployee(Employee employee) {
        logger.info("Inserting employee -> {}", employeeService.save(employee));
    }
}
