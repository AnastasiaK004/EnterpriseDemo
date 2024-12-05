package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Employee;

public record EmployeeResponseDto(Long id,
                                  String fullName,
                                  Integer salary,
                                  Long departmentId) {
    public EmployeeResponseDto(Employee employee) {
        this(employee.getId(), employee.getFullName(), employee.getSalary(), employee.getDepartment().getId());
    }
}
