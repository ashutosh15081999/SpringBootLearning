package com.microservice.organisationservice.controller;

import com.microservice.organisationservice.dto.OrganisationDto;
import com.microservice.organisationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organisation")
@AllArgsConstructor
public class OrganisationController {
    OrganisationService organisationService;

    @PostMapping
    public OrganisationDto createOrganisation(@RequestBody OrganisationDto organisationDto){
        return organisationService.createOrganisation(organisationDto);
    }

    @GetMapping("{code}")
    public OrganisationDto getOrganisationByCode(@PathVariable("code") String organisationCode){
        return organisationService.getOrganisation(organisationCode);
    }
}
