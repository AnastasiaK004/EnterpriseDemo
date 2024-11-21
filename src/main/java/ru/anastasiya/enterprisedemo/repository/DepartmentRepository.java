package ru.anastasiya.enterprisedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anastasiya.enterprisedemo.entity.Department;
import ru.anastasiya.enterprisedemo.entity.Employee;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
