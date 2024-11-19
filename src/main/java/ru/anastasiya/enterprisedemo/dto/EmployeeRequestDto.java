package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Department;

public record EmployeeRequestDto(String fullName, Integer salary) {
}
