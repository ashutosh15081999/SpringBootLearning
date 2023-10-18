package com.microservice.organisationservice.service;

import com.microservice.organisationservice.dto.OrganisationDto;

public interface OrganisationService {

    OrganisationDto createOrganisation(OrganisationDto organisationDto);

    OrganisationDto getOrganisation(String code);
}
