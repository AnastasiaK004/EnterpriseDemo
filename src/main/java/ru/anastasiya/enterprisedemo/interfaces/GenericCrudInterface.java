package ru.anastasiya.enterprisedemo.interfaces;

import java.util.List;

/**
 * Интерфейс для сервисов и контроллеров, которые должны реализовать CRUD методы.
 *
 * @param <ID> тип идентификатора сущности (например, Long)
 * @param <IN> тип входного DTO для создания и обновления сущности
 * @param <OUT> тип выходного DTO для возврата информации о сущности
 */
public interface GenericCrudInterface<ID, IN, OUT> {

    /**
     * Создает новую сущность.
     * @param in входной объект DTO с данными для создания.
     * @return объект DTO с данными созданной сущности.
     */
    OUT create(IN in);

    /**
     * Получает сущность по её идентификатору.
     * @param id идентификатор сущности.
     * @return объект DTO с данными сущности.
     */
    OUT get(ID id);

    /**
     * Получает список всех сущностей.
     * @return список DTO всех сущностей.
     */
    List<OUT> getAll();

    /**
     * Обновляет сущность по её идентификатору.
     * @param id идентификатор сущности.
     * @param in входной объект DTO с обновленными данными.
     * @return объект DTO с обновленными данными сущности.
     */
    OUT update(ID id, IN in);

    /**
     * Удаляет сущность по её идентификатору.
     * @param id идентификатор сущности.
     */
    void delete(ID id);
}