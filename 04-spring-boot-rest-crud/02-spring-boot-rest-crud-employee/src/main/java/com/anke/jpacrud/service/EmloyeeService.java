package com.anke.jpacrud.service;

import com.anke.jpacrud.dao.IEmployeeDAO;
import com.anke.jpacrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmloyeeService implements IEmployeeService{

    private IEmployeeDAO employeeDAO;

    @Autowired
    public EmloyeeService(IEmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
