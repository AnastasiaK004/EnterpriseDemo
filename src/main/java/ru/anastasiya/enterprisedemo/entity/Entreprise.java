package ru.anastasiya.enterprisedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise { //Переход на Spring Data JPA в дальнейшем
    Long id;
    String name;
    String description;
    List<Department> departmentList;
}
