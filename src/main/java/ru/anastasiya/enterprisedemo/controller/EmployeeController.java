package ru.anastasiya.enterprisedemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.anastasiya.enterprisedemo.dto.EmployeeRequestDto;
import ru.anastasiya.enterprisedemo.dto.EmployeeResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.service.EmployeeService;

import java.util.List;

/**
 * Контроллер для управления сотрудниками.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController implements GenericCrudInterface<Long, EmployeeRequestDto, EmployeeResponseDto> {

    // Сервис для обработки операций с сотрудниками
    private final EmployeeService employeeService;

    /**
     * Создание нового сотрудника.
     * @param employeeRequestDto данные нового сотрудника.
     * @return информация о созданном сотруднике.
     */
    @Override
    @PostMapping
    public EmployeeResponseDto create(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.create(employeeRequestDto);
    }

    /**
     * Получение сотрудника по его ID.
     * @param id идентификатор сотрудника.
     * @return информация о сотруднике.
     */
    @Override
    @GetMapping("/{id}")
    public EmployeeResponseDto get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    /**
     * Получение списка всех сотрудников.
     * @return список сотрудников.
     */
    @Override
    @GetMapping("/all")
    public List<EmployeeResponseDto> getAll() {
        return employeeService.getAll();
    }

    /**
     * Обновление информации о сотруднике.
     * @param id идентификатор сотрудника.
     * @param employeeRequestDto новые данные сотрудника.
     * @return обновленная информация о сотруднике.
     */
    @Override
    @PutMapping("/{id}")
    public EmployeeResponseDto update(@PathVariable Long id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.update(id, employeeRequestDto);
    }

    /**
     * Удаление сотрудника по его ID.
     * @param id идентификатор сотрудника.
     */
    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
