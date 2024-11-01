package com.Employee.EmployeeCrud.Service;

import com.Employee.EmployeeCrud.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity createEmployee(EmployeeEntity employee);
    EmployeeEntity getEmployeeById(Long id);
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails);
    void deleteEmployee(Long id);
}
