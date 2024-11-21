package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.EmployeeRequestDto;
import ru.anastasiya.enterprisedemo.dto.EmployeeResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
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

    /**
     * Создание нового сотрудника.
     * @param employeeRequestDto данные нового сотрудника.
     * @return объект DTO с данными созданного сотрудника.
     */
    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        return null; // TODO: реализовать при реализации логики
    }

    /**
     * Получение сотрудника по его ID.
     * @param id идентификатор сотрудника.
     * @return объект DTO с данными сотрудника.
     */
    @Override
    public EmployeeResponseDto get(Long id) {
        return null; // TODO: реализовать при реализации логики
    }

    /**
     * Получение списка всех сотрудников.
     * @return список DTO всех сотрудников.
     */
    @Override
    public List<EmployeeResponseDto> getAll() {
        return List.of(); // TODO: реализовать при реализации логики
    }

    /**
     * Обновление информации о сотруднике.

     * @param id идентификатор сотрудника.
     * @param employeeRequestDto новые данные сотрудника.
     * @return объект DTO с обновленными данными сотрудника.
     */
    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto employeeRequestDto) {
        return null; // TODO: реализовать при реализации логики
    }

    /**
     * Удаление сотрудника по его ID.
     * @param id идентификатор сотрудника.
     */
    @Override
    public void delete(Long id) {
        // TODO: реализовать при реализации логики
    }
}
