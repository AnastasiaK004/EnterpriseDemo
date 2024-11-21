package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.DepartmentRequestDto;
import ru.anastasiya.enterprisedemo.dto.DepartmentResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.repository.DepartmentRepository;

import java.util.List;

/**
 * Сервис для обработки операций с отделами.
 * Реализация методов будет добавлена позднее при подключении Spring Data JPA.
 */
@Service
@RequiredArgsConstructor
public class DepartmentService implements GenericCrudInterface<Long, DepartmentRequestDto, DepartmentResponseDto> {
    private final DepartmentRepository departmentRepository;

    /**
     * Создание нового отдела.
     * @param departmentRequestDto данные нового отдела.
     * @return объект DTO с данными созданного отдела.
     */
    @Override
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        return null; // TODO: реализовать при реализации логики
    }

    /**
     * Получение отдела по его ID.
     * @param id идентификатор отдела.
     * @return объект DTO с данными отдела.
     */
    @Override
    public DepartmentResponseDto get(Long id) {
        return null; // TODO: реализовать при реализации логики
    }

    /**
     * Получение списка всех отделов.
     * @return список DTO всех отделов.
     */
    @Override
    public List<DepartmentResponseDto> getAll() {
        return List.of(); // TODO: реализовать при реализации логики
    }

    /**
     * Обновление информации об отделе.
     * @param id идентификатор отдела.
     * @param departmentRequestDto новые данные отдела.
     * @return объект DTO с обновленными данными отдела.
     */
    @Override
    public DepartmentResponseDto update(Long id, DepartmentRequestDto departmentRequestDto) {
        return null; // TODO: реализовать при реализации логики
    }

    /**
     * Удаление отдела по его ID.
     * @param id идентификатор отдела.
     */
    @Override
    public void delete(Long id) {
        // TODO: реализовать при реализации логики
    }
}
