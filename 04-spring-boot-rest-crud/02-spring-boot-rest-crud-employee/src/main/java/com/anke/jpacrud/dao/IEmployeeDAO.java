package com.anke.jpacrud.dao;

import com.anke.jpacrud.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
