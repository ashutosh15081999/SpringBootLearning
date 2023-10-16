package com.microservice.employeeservice.service;

import com.microservice.employeeservice.dto.ApiResponseDto;
import com.microservice.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(String email);

    ApiResponseDto getEmployeeById(Long id);
}
