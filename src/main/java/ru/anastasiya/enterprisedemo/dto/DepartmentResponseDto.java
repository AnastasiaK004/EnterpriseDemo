package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Department;
import ru.anastasiya.enterprisedemo.entity.Employee;

import java.util.List;

public record DepartmentResponseDto(
    Long id,
    String name,
    String description,
    List<EmployeeResponseDto> employees
) {
    public DepartmentResponseDto(Department department) {
        this(
            department.getId(),
            department.getName(),
            department.getDescription(),
            department.getEmployees().stream().map(EmployeeResponseDto::new).toList()
        );
    }
}
