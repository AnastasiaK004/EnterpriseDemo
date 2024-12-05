package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.DepartmentRequestDto;
import ru.anastasiya.enterprisedemo.dto.DepartmentResponseDto;
import ru.anastasiya.enterprisedemo.dto.EmployeeResponseDto;
import ru.anastasiya.enterprisedemo.entity.Department;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.repository.DepartmentRepository;
import ru.anastasiya.enterprisedemo.repository.EnterpriseRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для обработки операций с отделами.
 * Реализация методов будет добавлена позднее при подключении Spring Data JPA.
 */
@Service
@RequiredArgsConstructor
public class DepartmentService implements GenericCrudInterface<Long, DepartmentRequestDto, DepartmentResponseDto> {
    private final DepartmentRepository departmentRepository;
    private final EnterpriseRepository enterpriseRepository;

    /**
     * Создание нового отдела.
     *
     * @param departmentRequestDto данные нового отдела.
     * @return объект DTO с данными созданного отдела.
     */
    @Override
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        var enterprise = enterpriseRepository.findById(departmentRequestDto.enterpriseId()).orElseThrow();
        var department = new Department(
            null,
            departmentRequestDto.name(),
            departmentRequestDto.description(),
            new ArrayList<>(),
            enterprise
        );
        return new DepartmentResponseDto(departmentRepository.save(department));
    }

    /**
     * Получение отдела по его ID.
     *
     * @param id идентификатор отдела.
     * @return объект DTO с данными отдела.
     */
    @Override
    public DepartmentResponseDto get(Long id) {
        return new DepartmentResponseDto(departmentRepository.findById(id).orElseThrow());
    }

    /**
     * Получение списка всех отделов.
     *
     * @return список DTO всех отделов.
     */
    @Override
    public List<DepartmentResponseDto> getAll() {
        return departmentRepository.findAll().stream().map(DepartmentResponseDto::new).toList();
    }

    /**
     * Обновление информации об отделе.
     *
     * @param id                   идентификатор отдела.
     * @param departmentRequestDto новые данные отдела.
     * @return объект DTO с обновленными данными отдела.
     */
    @Override
    public DepartmentResponseDto update(Long id, DepartmentRequestDto departmentRequestDto) {
        var department = departmentRepository.findById(id).orElseThrow();
        department.setName(departmentRequestDto.name());
        department.setDescription(departmentRequestDto.description());
        department.setEnterprise(enterpriseRepository.findById(departmentRequestDto.enterpriseId()).orElseThrow());
        return new DepartmentResponseDto(departmentRepository.save(department));
    }

    /**
     * Удаление отдела по его ID.
     *
     * @param id идентификатор отдела.
     */
    @Override
    public void delete(Long id) {
       departmentRepository.deleteById(id);
    }

    public List<EmployeeResponseDto> employees(Long id) {
        var department = departmentRepository.findById(id).orElseThrow();
        return department.getEmployees().stream().map(EmployeeResponseDto::new).toList();
    }
}
