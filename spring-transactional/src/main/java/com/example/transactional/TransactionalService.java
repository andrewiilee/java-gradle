package com.example.transactional;

import com.example.employee.EmployeeService;
import com.example.employee.entity.Employee;
import com.example.student.dao.StudentDAO;
import com.example.student.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class TransactionalService {
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
        log.info("Inserting student-> {}", studentDAO.insert(student));
    }

    private void saveEmployee(Employee employee) {
        log.info("Inserting employee -> {}", employeeService.save(employee));
    }
}
