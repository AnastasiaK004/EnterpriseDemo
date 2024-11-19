package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Employee;

import java.util.List;

public record DepartmentRequestDto(
    String name,
    String description) {
}
