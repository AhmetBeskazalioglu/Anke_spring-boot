package com.anke.jpacrud.dao;

import com.anke.jpacrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Bu interface, JpaRepository interface'sinden türetilmiştir.
 * JpaRepository interface'i, CRUD işlemlerini gerçekleştirmek için gerekli olan tüm metotları içerir.
 * JpaRepository interface'i, Entity sınıfı ve Entity'nin primary key veri tipini parametre olarak alır.
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
