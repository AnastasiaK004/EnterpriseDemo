package ru.anastasiya.enterprisedemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.anastasiya.enterprisedemo.dto.DepartmentRequestDto;
import ru.anastasiya.enterprisedemo.dto.DepartmentResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.service.DepartmentService;

import java.util.List;

/**
 * Контроллер для управления отделами.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController implements GenericCrudInterface<Long, DepartmentRequestDto, DepartmentResponseDto> {

    // Сервис для обработки операций с отделами
    private final DepartmentService departmentService;

    /**
     * Создание нового отдела.
     * @param departmentRequestDto данные нового отдела.
     * @return информация о созданном отделе.
     */
    @Override
    @PostMapping
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        return departmentService.create(departmentRequestDto);
    }

    /**
     * Получение отдела по его ID.
     * @param id идентификатор отдела.
     * @return информация об отделе.
     */
    @Override
    @GetMapping
    public DepartmentResponseDto get(Long id) {
        return departmentService.get(id);
    }

    /**
     * Получение списка всех отделов.
     * @return список отделов.
     */
    @Override
    @GetMapping("/all")
    public List<DepartmentResponseDto> getAll() {
        return departmentService.getAll();
    }

    /**
     * Обновление информации об отделе.
     * @param id идентификатор отдела.
     * @param departmentRequestDto новые данные отдела.
     * @return обновленная информация об отделе.
     */
    @Override
    @PatchMapping
    public DepartmentResponseDto update(Long id, DepartmentRequestDto departmentRequestDto) {
        return departmentService.update(id, departmentRequestDto);
    }

    /**
     * Удаление отдела по его ID.
     * @param id идентификатор отдела.
     */
    @Override
    @DeleteMapping
    public void delete(Long id) {
        departmentService.delete(id);
    }
}
