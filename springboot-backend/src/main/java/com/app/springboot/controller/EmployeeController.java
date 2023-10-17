package com.app.springboot.controller;

import com.app.springboot.exception.ResourceNotFoundException;
import com.app.springboot.model.Employee;
import com.app.springboot.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //get employee rest api
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    //create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exists with id : "+id));
        return ResponseEntity.ok(employee);
    }

    //update employee by id
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee updateEmployee  = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exists with id : "+id));
        updateEmployee.setFirstName(employee.getFirstName()!=null ? employee.getFirstName() : "");
        updateEmployee.setLastName(employee.getLastName()!=null ? employee.getLastName() : "");
        updateEmployee.setEmailId(employee.getEmailId()!=null ? employee.getEmailId() : "");
        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //delete employee rest api by id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Employee>> deleteEmployee(@PathVariable Long id){
        Employee employee =  employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exists with id : "+id));

        employeeRepository.delete(employee);
        Map<String,Employee> response = new HashMap<>();
        response.put("deleted employee",employee);
        return ResponseEntity.ok(response);
    }
}
