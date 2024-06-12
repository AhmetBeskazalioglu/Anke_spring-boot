package com.anke.cruddemo.dao;

import com.anke.cruddemo.entity.LombokFamily;

public interface FamilyDAO {
    void save(LombokFamily theFamily);
    LombokFamily findById(int id);
}
