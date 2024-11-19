package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Department;

public record EmployeeResponseDto(Long id,
                                  String fullName,
                                  Integer salary,
                                  Long departmentId) {
}
