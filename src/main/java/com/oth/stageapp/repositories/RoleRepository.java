package com.oth.stageapp.repositories;

import com.oth.stageapp.entities.RoleApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleApp, Long> {
    RoleApp findRoleAppByName(String name);

    Optional<RoleApp> findById(Optional<Long> id);
}
