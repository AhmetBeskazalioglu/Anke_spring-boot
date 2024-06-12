package com.anke.cruddemo.dao;

import com.anke.cruddemo.entity.LombokFamily;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public LombokFamily findById(int id) {
        return entityManager.find(LombokFamily.class, id);
    }

    @Override
    public List<LombokFamily> findAll() {
        return entityManager.createQuery("from LombokFamily", LombokFamily.class).getResultList();
    }
}
