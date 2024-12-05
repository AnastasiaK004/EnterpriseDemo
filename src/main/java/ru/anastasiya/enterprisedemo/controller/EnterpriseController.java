package ru.anastasiya.enterprisedemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.anastasiya.enterprisedemo.dto.DepartmentResponseDto;
import ru.anastasiya.enterprisedemo.dto.EnterpriseRequestDto;
import ru.anastasiya.enterprisedemo.dto.EnterpriseResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.service.EnterpriseService;

import java.util.List;

/**
 * Контроллер для управления предприятиями.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/enterprise")
public class EnterpriseController implements GenericCrudInterface<Long, EnterpriseRequestDto, EnterpriseResponseDto> {

    // Сервис для обработки операций с предприятиями
    private final EnterpriseService enterpriseService;

    /**
     * Создание нового предприятия.
     * @param enterpriseRequestDto данные нового предприятия.
     * @return информация о созданном предприятии.
     */
    @Override
    @PostMapping
    public EnterpriseResponseDto create(@RequestBody EnterpriseRequestDto enterpriseRequestDto) {
        return enterpriseService.create(enterpriseRequestDto);
    }

    /**
     * Получение предприятия по его ID.
     * @param id идентификатор предприятия.
     * @return информация о предприятии.
     */
    @Override
    @GetMapping("/{id}")
    public EnterpriseResponseDto get(@PathVariable Long id) {
        return enterpriseService.get(id);
    }

    /**
     * Получение списка всех предприятий.
     * @return список предприятий.
     */
    @Override
    @GetMapping("/all")
    public List<EnterpriseResponseDto> getAll() {
        return enterpriseService.getAll();
    }

    /**
     * Обновление информации о предприятии.
     * @param id идентификатор предприятия.
     * @param enterpriseRequestDto новые данные предприятия.
     * @return обновленная информация о предприятии.
     */
    @Override
    @PutMapping("/{id}")
    public EnterpriseResponseDto update(@PathVariable Long id, @RequestBody EnterpriseRequestDto enterpriseRequestDto) {
        return enterpriseService.update(id, enterpriseRequestDto);
    }

    /**
     * Удаление предприятия по его ID.
     * @param id идентификатор предприятия.
     */
    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        enterpriseService.delete(id);
    }

    @GetMapping("/{id}/departments")
    public List<DepartmentResponseDto> getDepartments(@PathVariable Long id){
        return enterpriseService.departments(id);
    }
}
