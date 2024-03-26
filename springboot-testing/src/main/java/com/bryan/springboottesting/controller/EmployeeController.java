package com.bryan.springboottesting.controller;

import com.bryan.springboottesting.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @PostMapping("/save")
    ResponseEntity<String>registerEmployee(@RequestBody Employee employee){
        //TODO : LOGICA PARA GUARDAR EL OBJETO LOCAL EN TU SERVICIO
        String message="Recurso creado exitosamente";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=new ArrayList<>();
        Employee employee1=new Employee();
        employee1.setId(1L);
        employee1.setFirstName("Bryan");
        employee1.setLastName("Arredondo");
        employee1.setEmail("bpao99@gmail.com");
        employees.add(employee1);

        Employee employee2=new Employee();
        employee2.setId(2L);
        employee2.setFirstName("ASDASD");
        employee2.setLastName("DASDA");
        employee2.setEmail("prueba1@gmail.com");
        employees.add(employee2);

        Employee employee3=new Employee();
        employee3.setId(3L);
        employee3.setFirstName("prueba");
        employee3.setLastName("testing");
        employee3.setEmail("pruebaTesting@gmail.com");
        employees.add(employee3);

        return ResponseEntity.ok(employees);
    }
}
