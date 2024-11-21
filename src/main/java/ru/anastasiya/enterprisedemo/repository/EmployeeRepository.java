package ru.anastasiya.enterprisedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anastasiya.enterprisedemo.entity.Employee;
import ru.anastasiya.enterprisedemo.entity.Enterprise;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
