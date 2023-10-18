package com.microservice.employeeservice.service.impl;

import com.microservice.employeeservice.Entity.EmployeeEntity;
import com.microservice.employeeservice.dto.ApiResponseDto;
import com.microservice.employeeservice.dto.DepartmentDto;
import com.microservice.employeeservice.dto.EmployeeDto;
import com.microservice.employeeservice.dto.OrganisationDto;
import com.microservice.employeeservice.mapper.EmployeeMapper;
import com.microservice.employeeservice.repository.EmployeeRepository;
import com.microservice.employeeservice.service.APIClient;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employee = EmployeeMapper.mapToEmployeeEntity(employeeDto);
        EmployeeEntity createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createdEmployee);
    }

    @Override
    public EmployeeDto getEmployee(String email) {
        EmployeeEntity employee = employeeRepository.findByEmail(email);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganisationDto organisationDto = webClient.get()
                .uri("http://localhost:8083/api/organisation/" + employee.getOrganisationCode())
                .retrieve()
                .bodyToMono(OrganisationDto.class)
                .block();
//        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        return new ApiResponseDto(
                employeeDto,
                departmentDto,
                organisationDto
        );
    }
}
