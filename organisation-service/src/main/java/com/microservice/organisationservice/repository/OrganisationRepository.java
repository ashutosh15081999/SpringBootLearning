package com.microservice.organisationservice.repository;

import com.microservice.organisationservice.entity.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<OrganisationEntity, Long> {

    OrganisationEntity findByOrganisationCode(String organisationCode);
}
