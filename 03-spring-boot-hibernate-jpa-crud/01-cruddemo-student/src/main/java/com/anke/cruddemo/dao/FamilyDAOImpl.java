package com.anke.cruddemo.dao;

import com.anke.cruddemo.entity.LombokFamily;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FamilyDAOImpl implements FamilyDAO {

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

    @Override
    public List<LombokFamily> findByLastName(String theLastName) {
        return entityManager.createQuery("from LombokFamily where surname=:thePlaceHolder", LombokFamily.class) // from LombokFamily is the entity name
                .setParameter("thePlaceHolder", theLastName) // thePlaceHolder is a placeholder
                .getResultList(); // getSingleResult() is used to retrieve a single result from the query
    }

    @Transactional
    @Override
    public void update(LombokFamily theFamily) {
        LombokFamily updatedFamily = findById(theFamily.getId());
        updatedFamily.setSurname("UpdatedSurname");
        entityManager.merge(updatedFamily);
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    @Transactional
    @Override
    public int deleteAll() {
        int count = entityManager.createQuery("delete from LombokFamily").executeUpdate();
        return count;
    }
}
