package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Department;

import java.util.List;

public record EnterpriseRequestDto(
    String name,
    String description
) {
}
