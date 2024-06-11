package com.anke.cruddemo.dao;

import com.anke.cruddemo.entity.LombokFamily;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FamilyDAOImpl implements FamilyDAO{

    private EntityManager entityManager;

    @Autowired
    public FamilyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(LombokFamily theFamily) {
        entityManager.persist(theFamily);
    }
}
