package com.microservice.employeeservice.mapper;

import com.microservice.employeeservice.Entity.EmployeeEntity;
import com.microservice.employeeservice.dto.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto){
        return new EmployeeEntity(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
    }

    public static EmployeeDto mapToEmployeeDto(EmployeeEntity employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
    }
}
