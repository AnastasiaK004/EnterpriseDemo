package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Employee;

import java.util.List;

public record DepartmentResponseDto(
    Long id,
    String name,
    String description,
    List<Long> employeesIds
) {
}
