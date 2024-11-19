package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.EnterpriseRequestDto;
import ru.anastasiya.enterprisedemo.dto.EnterpriseResponseDto;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseService implements GenericCrudInterface<Long, EnterpriseRequestDto, EnterpriseResponseDto> {
    @Override
    public EnterpriseResponseDto create(EnterpriseRequestDto enterpriseRequestDto) {
        return null; //TODO
    }

    @Override
    public EnterpriseResponseDto get(Long id) {
        return null; //TODO
    }

    @Override
    public List<EnterpriseResponseDto> getAll() {
        return List.of(); //TODO
    }

    @Override
    public EnterpriseResponseDto update(Long id, EnterpriseRequestDto enterpriseRequestDto) {
        return null; //TODO
    }

    @Override
    public void delete(Long id) {
        //TODO
    }
}
