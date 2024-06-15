package com.anke.jpacrud.service;

import com.anke.jpacrud.dao.EmployeeRepository;
import com.anke.jpacrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Bu sınıf, IEmployeeService interface'sinden türetilmiştir.
 * IEmployeeService interface'i, Employee sınıfı için CRUD işlemlerini tanımlar.
 * Bu sınıf, EmployeeRepository sınıfını enjekte eder ve bu sınıfı kullanarak CRUD işlemlerini gerçekleştirir.
 */
@Service
public class EmloyeeService implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmloyeeService(EmployeeRepository theEmployeeDAO) {
        employeeRepository = theEmployeeDAO;
    }

    /**
     * Bu metot, tüm çalışanları döndürür.
     *
     * @return
     */
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    /**
     * Bu metot, çalışan id'sine göre çalışanı döndürür.
     *
     * @param theId
     * @return
     */
    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId); // Optional, null pointer exception'ı önlemek için kullanılır.

        Employee theEmployee = null;

        if (result.isPresent())
            theEmployee = result.get();
        else
            throw new RuntimeException("Did not find employee id - " + theId);

        return theEmployee;
    }

    /**
     * Bu metot, çalışanı kaydeder.
     * Eğer çalışanın id'si varsa, çalışan güncellenir.
     * Eğer çalışanın id'si yoksa, yeni bir çalışan eklenir.
     * id=0 ise yeni bir çalışan eklenir.
     * id!=0 ise çalışan güncellenir.
     *
     * Ayrıca bu metot, @Transactional annotation'ı ile işaretlenmiştir.
     * Bu annotation, metotun bir işlemi gerçekleştirdiğini belirtir.
     * Eğer işlem başarılı bir şekilde gerçekleşirse, işlemi commit eder.
     * Eğer işlemde bir hata olursa, işlemi rollback eder.
     *
     * @param theEmployee
     * @return
     */
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    /**
     * Bu metot, çalışan id'sine göre çalışanı siler.
     *
     * @param theId
     */
    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
