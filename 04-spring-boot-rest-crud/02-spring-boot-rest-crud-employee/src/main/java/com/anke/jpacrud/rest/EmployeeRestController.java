package com.anke.jpacrud.rest;

import com.anke.jpacrud.entity.Employee;
import com.anke.jpacrud.service.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private IEmployeeService employeeService;

    public EmployeeRestController(IEmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
