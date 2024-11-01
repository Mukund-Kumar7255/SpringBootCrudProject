package com.Employee.EmployeeCrud.Service;

import com.Employee.EmployeeCrud.Entity.EmployeeEntity;
import com.Employee.EmployeeCrud.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Couldn't find employee'"));
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails) {
        //Optional<EmployeeEntity> employee = employeeRepo.findById(id);
        EmployeeEntity employee =employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Could not find employee"));
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setAge(employeeDetails.getAge());
        employee.setDateofjoining(employeeDetails.getDateofjoining());
        employee.setIsActive(employeeDetails.getIsActive());
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
