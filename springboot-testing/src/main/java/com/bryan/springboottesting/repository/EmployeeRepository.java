package com.bryan.springboottesting.repository;

import com.bryan.springboottesting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByFirstNameIgnoreCase(String firstname);
}
