package com.oth.stageapp.repositories;

import com.oth.stageapp.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findPermissionByPermission(String name);
}
