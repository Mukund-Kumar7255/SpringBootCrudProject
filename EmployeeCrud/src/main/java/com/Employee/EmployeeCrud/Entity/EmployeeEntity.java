package com.Employee.EmployeeCrud.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="Employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message="Required field name")
    @Size(min=1, max=10,message = "Number of characters in name should be less")
    private String name;
    @Email(message="Email should be valid email")
    private String email;
    @Max(value = 80,message ="Age cannot be greater than 80")
    @Min(value = 10,message ="Age cannot be less than 18")
    private Integer age;
    @PastOrPresent(message = "DateOfJoining field in employee can't be in the future")
    private LocalDate dateofjoining;
    @AssertTrue(message = "Employee should be is active")
    private Boolean isActive;
}
