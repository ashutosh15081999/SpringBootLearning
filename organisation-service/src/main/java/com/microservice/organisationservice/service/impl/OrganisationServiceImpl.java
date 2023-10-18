package com.microservice.organisationservice.service.impl;

import com.microservice.organisationservice.dto.OrganisationDto;
import com.microservice.organisationservice.entity.OrganisationEntity;
import com.microservice.organisationservice.mapper.OrganisationMapper;
import com.microservice.organisationservice.repository.OrganisationRepository;
import com.microservice.organisationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    OrganisationRepository organisationRepository;

    @Override
    public OrganisationDto createOrganisation(OrganisationDto organisationDto) {
        OrganisationEntity entity = OrganisationMapper.mapToOrganisationEntity(organisationDto);
        OrganisationEntity organisationEntity = organisationRepository.save(entity);
        return OrganisationMapper.mapToOrganisationDto(organisationEntity);
    }

    @Override
    public OrganisationDto getOrganisation(String code) {
        OrganisationEntity organisationEntity = organisationRepository.findByOrganisationCode(code);
        return OrganisationMapper.mapToOrganisationDto(organisationEntity);
    }
}
