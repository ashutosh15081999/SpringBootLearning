package com.microservice.departmentservice.service;

import com.microservice.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getDepartments();

    DepartmentDto getDepartment(String departmentCode);
}
