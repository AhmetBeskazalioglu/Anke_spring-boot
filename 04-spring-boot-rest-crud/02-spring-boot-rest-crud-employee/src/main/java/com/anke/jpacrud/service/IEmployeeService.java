package com.anke.jpacrud.service;

import com.anke.jpacrud.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
