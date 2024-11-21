package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.EnterpriseRequestDto;
import ru.anastasiya.enterprisedemo.dto.EnterpriseResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.repository.EnterpriseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseService implements GenericCrudInterface<Long, EnterpriseRequestDto, EnterpriseResponseDto> {
    private final EnterpriseRepository enterpriseRepository;

    @Override
    public EnterpriseResponseDto create(EnterpriseRequestDto enterpriseRequestDto) {
        return null; // TODO: реализовать при реализации логики
    }

    @Override
    public EnterpriseResponseDto get(Long id) {
        return null; // TODO: реализовать при реализации логики
    }

    @Override
    public List<EnterpriseResponseDto> getAll() {
        return List.of(); // TODO: реализовать при реализации логики
    }

    @Override
    public EnterpriseResponseDto update(Long id, EnterpriseRequestDto enterpriseRequestDto) {
        return null; // TODO: реализовать при реализации логики
    }

    @Override
    public void delete(Long id) {
        // TODO: реализовать при реализации логики
    }
}
