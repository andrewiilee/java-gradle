package com.example.employee;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteByFirstName(String firstName) {
        employeeRepository.deleteEmployeeByFirstName(firstName);
    }
}
