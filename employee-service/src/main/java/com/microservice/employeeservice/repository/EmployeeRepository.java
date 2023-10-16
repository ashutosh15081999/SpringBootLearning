package com.microservice.employeeservice.repository;

import com.microservice.employeeservice.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByEmail(String email);
}
