package ru.anastasiya.enterprisedemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anastasiya.enterprisedemo.dto.DepartmentResponseDto;
import ru.anastasiya.enterprisedemo.dto.EnterpriseRequestDto;
import ru.anastasiya.enterprisedemo.dto.EnterpriseResponseDto;
import ru.anastasiya.enterprisedemo.entity.Enterprise;
import ru.anastasiya.enterprisedemo.interfaces.GenericCrudInterface;
import ru.anastasiya.enterprisedemo.repository.EnterpriseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EnterpriseService implements GenericCrudInterface<Long, EnterpriseRequestDto, EnterpriseResponseDto> {
    private final EnterpriseRepository enterpriseRepository;

    @Override
    public EnterpriseResponseDto create(EnterpriseRequestDto enterpriseRequestDto) {
        var enterprise = new Enterprise(
            null,
            enterpriseRequestDto.name(),
            enterpriseRequestDto.description(),
            new ArrayList<>()
        );
        return new EnterpriseResponseDto(enterpriseRepository.save(enterprise));
    }

    @Override
    public EnterpriseResponseDto get(Long id) {
        return new EnterpriseResponseDto(Objects.requireNonNull(enterpriseRepository.findById(id).orElse(null)));
    }

    @Override
    public List<EnterpriseResponseDto> getAll() {
        return enterpriseRepository.findAll()
            .stream()
            .map(EnterpriseResponseDto::new)
            .toList();
    }


    @Override
    public EnterpriseResponseDto update(Long id, EnterpriseRequestDto enterpriseRequestDto) {
        var enterprise = enterpriseRepository.findById(id).orElseThrow();
        enterprise.setName(enterpriseRequestDto.name());
        enterprise.setDescription(enterpriseRequestDto.description());
        return new EnterpriseResponseDto(enterpriseRepository.save(enterprise));
    }

    @Override
    public void delete(Long id) {
        enterpriseRepository.deleteById(id);
    }

    public List<DepartmentResponseDto> departments(Long id) {
        var enterprise = enterpriseRepository.findById(id).orElseThrow();
        return enterprise.getDepartmentList().stream().map(DepartmentResponseDto::new).toList();
    }
}
