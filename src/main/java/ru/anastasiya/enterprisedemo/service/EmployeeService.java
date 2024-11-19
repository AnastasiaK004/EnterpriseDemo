package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.EmployeeRequestDto;
import ru.anastasiya.enterprisedemo.dto.EmployeeResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;

import java.util.List;

/**
 * Сервис для обработки операций с сотрудниками.
 * Реализация методов будет добавлена позднее при подключении Spring Data JPA.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService implements GenericCrudInterface<Long, EmployeeRequestDto, EmployeeResponseDto> {

    /**
     * Создание нового сотрудника.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param employeeRequestDto данные нового сотрудника.
     * @return объект DTO с данными созданного сотрудника.
     */
    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        return null; // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Получение сотрудника по его ID.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param id идентификатор сотрудника.
     * @return объект DTO с данными сотрудника.
     */
    @Override
    public EmployeeResponseDto get(Long id) {
        return null; // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Получение списка всех сотрудников.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @return список DTO всех сотрудников.
     */
    @Override
    public List<EmployeeResponseDto> getAll() {
        return List.of(); // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Обновление информации о сотруднике.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param id идентификатор сотрудника.
     * @param employeeRequestDto новые данные сотрудника.
     * @return объект DTO с обновленными данными сотрудника.
     */
    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto employeeRequestDto) {
        return null; // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Удаление сотрудника по его ID.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param id идентификатор сотрудника.
     */
    @Override
    public void delete(Long id) {
        // TODO: реализовать при подключении Spring Data JPA
    }
}
