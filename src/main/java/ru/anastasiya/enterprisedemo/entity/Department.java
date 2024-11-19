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
public class Department {  //Переход на Spring Data JPA в дальнейшем
    Long id; //ID отдела, возможно name будет использоваться в качестве ID в дальнейшем
    String name;
    String description;
    List<Employee> employees;
}
