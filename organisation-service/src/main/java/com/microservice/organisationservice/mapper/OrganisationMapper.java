package com.microservice.organisationservice.mapper;

import com.microservice.organisationservice.dto.OrganisationDto;
import com.microservice.organisationservice.entity.OrganisationEntity;

public class OrganisationMapper {

    public static OrganisationDto mapToOrganisationDto(OrganisationEntity organisationEntity){
        return new OrganisationDto(
                organisationEntity.getId(),
                organisationEntity.getOrganisationName(),
                organisationEntity.getOrganisationDescription(),
                organisationEntity.getOrganisationCode(),
                organisationEntity.getCreatedDate()
        );
    }

    public static OrganisationEntity mapToOrganisationEntity(OrganisationDto organisationDto){
        return new OrganisationEntity(
                organisationDto.getId(),
                organisationDto.getOrganisationName(),
                organisationDto.getOrganisationDescription(),
                organisationDto.getOrganisationCode(),
                organisationDto.getCreatedDate()
        );
    }
}
