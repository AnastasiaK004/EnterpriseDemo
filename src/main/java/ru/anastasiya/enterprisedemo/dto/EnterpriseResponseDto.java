package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Department;

import java.util.List;

public record EnterpriseResponseDto(
    Long id,
    String name,
    String description,
    List<Long> departmentListIds
) {
}
