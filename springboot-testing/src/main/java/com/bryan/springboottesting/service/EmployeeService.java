package com.bryan.springboottesting.service;

import com.bryan.springboottesting.entity.Employee;
import com.bryan.springboottesting.error.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    Optional<Employee> findEmployeeByNameWithJPQL(String firstname);
    Optional<Employee> findByName(String firstname) ;
    Optional<Employee> findByFirstNameIgnoreCase(String firstname);
    Employee findEmployeeById(Long id) throws EmployeeNotFoundException;
}
