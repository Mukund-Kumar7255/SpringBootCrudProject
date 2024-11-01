package com.Employee.EmployeeCrud.Controller;

import com.Employee.EmployeeCrud.Entity.EmployeeEntity;
import com.Employee.EmployeeCrud.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<EmployeeEntity> createEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity createdEmployee = employeeService.saveEmployee(employeeEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
        try {
            EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employeeEntity);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
    }

    @GetMapping("/emp")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeEntities);
    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with id: " + id);
        }
    }
}
