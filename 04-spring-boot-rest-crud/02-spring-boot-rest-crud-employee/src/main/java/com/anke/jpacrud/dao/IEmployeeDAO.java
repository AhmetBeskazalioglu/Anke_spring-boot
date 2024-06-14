package com.anke.jpacrud.dao;

import com.anke.jpacrud.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    List<Employee> findAll();
}
