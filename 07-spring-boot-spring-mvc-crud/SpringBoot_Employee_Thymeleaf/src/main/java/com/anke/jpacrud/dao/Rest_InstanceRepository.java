package com.anke.jpacrud.dao;

import com.anke.jpacrud.entity.Rest_Instance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface Rest_InstanceRepository extends JpaRepository<Rest_Instance, Integer> {
}
