package com.anke.cruddemo.dao;

import com.anke.cruddemo.entity.LombokFamily;

import java.util.List;

public interface FamilyDAO {
    void save(LombokFamily theFamily);
    LombokFamily findById(int id);
    List<LombokFamily> findAll();
}
