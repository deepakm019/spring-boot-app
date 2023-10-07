package com.etherealyt.springbootapp.controller;

import com.etherealyt.springbootapp.model.Employee;
import com.etherealyt.springbootapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/ping")
    public String healthCheck(){
        return "pong";
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getSpecificEmployee(@PathVariable Long id){
        return employeeRepository.findById(id);
    }

    @PostMapping ("/employee")
    public Employee insertEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }
}
