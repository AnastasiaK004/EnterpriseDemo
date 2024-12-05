package ru.anastasiya.enterprisedemo.dto;

import ru.anastasiya.enterprisedemo.entity.Department;
import ru.anastasiya.enterprisedemo.entity.Enterprise;

import java.util.List;

public record EnterpriseResponseDto(
    Long id,
    String name,
    String description,
    List<DepartmentResponseDto> departments
) {
    public EnterpriseResponseDto(Enterprise enterprise) {
        this(
            enterprise.getId(),
            enterprise.getName(),
            enterprise.getDescription(),
            enterprise.getDepartmentList().stream().map(DepartmentResponseDto::new).toList()
        );
    }
}
