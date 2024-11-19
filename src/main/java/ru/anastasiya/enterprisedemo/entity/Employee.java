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
public class Employee { //Переход на Spring Data JPA в дальнейшем
    Long id;
    String fullName;
    Integer salary;
    Department department; //Bidirectional Many-to-One связь с отделами
}
