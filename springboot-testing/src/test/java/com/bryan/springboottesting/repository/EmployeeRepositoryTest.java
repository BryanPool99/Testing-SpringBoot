package com.bryan.springboottesting.repository;

import com.bryan.springboottesting.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Employee employee=Employee.builder()
                .firstName("Pool")
                .lastName("Ovalle")
                .email("pOvalle01@gmail.com")
                .build();
        testEntityManager.persist(employee);
    }
    @Test
    public void findEmployeeByFirstNameIgnoreCaseFound(){
        Optional<Employee> employee=employeeRepository.findByFirstNameIgnoreCase("Pool");
        assertEquals(employee.get().getFirstName(),"Pool");
        System.out.println("employee.get()= "+employee.get());
    }
    @Test
    public void findEmployeeByFirstNameIgnoreCaseNotFound(){
        Optional<Employee> employee=employeeRepository.findByFirstNameIgnoreCase("Not Found");
        assertEquals(employee,Optional.empty());
    }
}