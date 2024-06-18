package com.anke.cruddemo.dao;

import com.anke.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository /* This annotation is used to indicate that the class provides the mechanism for
 storage, retrieval, search, update and delete operation on objects.
 It is a specialization of the @Component annotation and allows for implementation classes to be auto-detected through classpath scanning.
 It is a good practice to annotate a DAO class with @Repository as it will be auto-detected by component-scanning and the DAO exceptions will be auto-translated into Spring DataAccessException.
 It is a marker for any class that fulfills the role or stereotype of a repository.

 Specialized annotation for repositories
 Supports component scanning
 Translates JDBC exceptions*/

public class StudentDAOImpl implements StudentDAO{

    // define fields for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager EntityManager) {
        this.entityManager = EntityManager;
    }

    // implement save method
    @Override
    @Transactional /* This annotation is used to indicate that the method is a transactional method.
     It is used to configure the transactional behavior of the method.
     // Exception handling
     */
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student order by firstName desc", Student.class).getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return entityManager.createQuery("from Student where lastName=:thePlaceHolder", Student.class)
                .setParameter("thePlaceHolder", lastName)
                .getResultList();
    }

    @Transactional
    @Override
    public void update(Student theStudent) {
        Student updatedStudent = findById(theStudent.getId());
        updatedStudent.setLastName("updated last name");
        entityManager.merge(updatedStudent);

    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    @Transactional
    @Override
    public int deleteAll() {
        int count = entityManager.createQuery("delete from Student").executeUpdate();
        return count;
    }
}
