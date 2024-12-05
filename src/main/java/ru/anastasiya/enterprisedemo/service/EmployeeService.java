package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.EmployeeRequestDto;
import ru.anastasiya.enterprisedemo.dto.EmployeeResponseDto;
import ru.anastasiya.enterprisedemo.dto.EnterpriseResponseDto;
import ru.anastasiya.enterprisedemo.entity.Employee;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.repository.DepartmentRepository;
import ru.anastasiya.enterprisedemo.repository.EmployeeRepository;

import java.util.List;

/**
 * Сервис для обработки операций с сотрудниками.
 * Реализация методов будет добавлена позднее при подключении Spring Data JPA.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService implements GenericCrudInterface<Long, EmployeeRequestDto, EmployeeResponseDto> {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    /**
     * Создание нового сотрудника.
     *
     * @param employeeRequestDto данные нового сотрудника.
     * @return объект DTO с данными созданного сотрудника.
     */
    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        var department = departmentRepository.findById(employeeRequestDto.departmentId()).orElseThrow();
        var employee = new Employee(null, employeeRequestDto.fullName(), employeeRequestDto.salary(), department);
        return new EmployeeResponseDto(employeeRepository.save(employee));
    }

    /**
     * Получение сотрудника по его ID.
     *
     * @param id идентификатор сотрудника.
     * @return объект DTO с данными сотрудника.
     */
    @Override
    public EmployeeResponseDto get(Long id) {
        return new EmployeeResponseDto(employeeRepository.findById(id).orElseThrow());
    }

    /**
     * Получение списка всех сотрудников.
     *
     * @return список DTO всех сотрудников.
     */
    @Override
    public List<EmployeeResponseDto> getAll() {
        return employeeRepository.findAll().stream().map(EmployeeResponseDto::new).toList();
    }

    /**
     * Обновление информации о сотруднике.
     *
     * @param id                 идентификатор сотрудника.
     * @param employeeRequestDto новые данные сотрудника.
     * @return объект DTO с обновленными данными сотрудника.
     */
    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto employeeRequestDto) {
        var employee = employeeRepository.findById(id).orElseThrow();
        employee.setFullName(employeeRequestDto.fullName());
        employee.setSalary(employeeRequestDto.salary());
        employee.setDepartment(departmentRepository.findById(employeeRequestDto.departmentId()).orElseThrow());
        return new EmployeeResponseDto(employeeRepository.save(employee));
    }

    /**
     * Удаление сотрудника по его ID.
     *
     * @param id идентификатор сотрудника.
     */
    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
