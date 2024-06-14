package com.anke.jpacrud.service;

import com.anke.jpacrud.dao.EmployeeRepository;
import com.anke.jpacrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmloyeeService implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmloyeeService(EmployeeRepository theEmployeeDAO) {
        employeeRepository = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent())
            theEmployee = result.get();
        else
            throw new RuntimeException("Did not find employee id - " + theId);

        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
