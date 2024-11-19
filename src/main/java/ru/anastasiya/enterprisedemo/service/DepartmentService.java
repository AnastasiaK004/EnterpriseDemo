package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.DepartmentRequestDto;
import ru.anastasiya.enterprisedemo.dto.DepartmentResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;

import java.util.List;

/**
 * Сервис для обработки операций с отделами.
 * Реализация методов будет добавлена позднее при подключении Spring Data JPA.
 */
@Service
@RequiredArgsConstructor
public class DepartmentService implements GenericCrudInterface<Long, DepartmentRequestDto, DepartmentResponseDto> {

    /**
     * Создание нового отдела.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param departmentRequestDto данные нового отдела.
     * @return объект DTO с данными созданного отдела.
     */
    @Override
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        return null; // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Получение отдела по его ID.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param id идентификатор отдела.
     * @return объект DTO с данными отдела.
     */
    @Override
    public DepartmentResponseDto get(Long id) {
        return null; // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Получение списка всех отделов.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @return список DTO всех отделов.
     */
    @Override
    public List<DepartmentResponseDto> getAll() {
        return List.of(); // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Обновление информации об отделе.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param id идентификатор отдела.
     * @param departmentRequestDto новые данные отдела.
     * @return объект DTO с обновленными данными отдела.
     */
    @Override
    public DepartmentResponseDto update(Long id, DepartmentRequestDto departmentRequestDto) {
        return null; // TODO: реализовать при подключении Spring Data JPA
    }

    /**
     * Удаление отдела по его ID.
     * Реализация будет добавлена при подключении Spring Data JPA.
     * @param id идентификатор отдела.
     */
    @Override
    public void delete(Long id) {
        // TODO: реализовать при подключении Spring Data JPA
    }
}
