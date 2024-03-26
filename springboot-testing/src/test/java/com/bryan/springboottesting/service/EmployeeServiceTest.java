package com.bryan.springboottesting.service;

import com.bryan.springboottesting.entity.Employee;
import com.bryan.springboottesting.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee employee=Employee.builder()
                .id(1L)
                .firstName("Bryan")
                .lastName("Arredondo")
                .email("BPAO99@gmail.com")
                .build();
        Mockito.when(employeeRepository.findByFirstNameIgnoreCase("Bryan")).thenReturn(Optional.of(employee));
    }
    @Test
    @DisplayName("Prueba de Obtencion de informacion de un local enviando un nombre válido")
    public void findByFirstNameIgnoreCaseShouldFound(){
        String employeeFirstname="Bryan";
        Employee employee=employeeService.findByFirstNameIgnoreCase(employeeFirstname).get();
        assertEquals(employeeFirstname,employee.getFirstName());
        System.out.println("employee = " + employee);
    }
}