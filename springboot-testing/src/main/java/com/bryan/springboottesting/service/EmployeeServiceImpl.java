package com.bryan.springboottesting.service;

import com.bryan.springboottesting.entity.Employee;
import com.bryan.springboottesting.error.EmployeeNotFoundException;
import com.bryan.springboottesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findEmployeeByNameWithJPQL(String firstname) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findByName(String firstname) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findByFirstNameIgnoreCase(String firstname) {
        return employeeRepository.findByFirstNameIgnoreCase(firstname);
    }

    @Override
    public Employee findEmployeeById(Long id) throws EmployeeNotFoundException {
        return null;
    }
}
