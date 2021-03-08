package com.oth.stageapp.service;

import com.oth.stageapp.entities.Permission;
import com.oth.stageapp.entities.RoleApp;
import com.oth.stageapp.repositories.PermissionRepository;
import com.oth.stageapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Permission createOrUpdatePermission(Permission permission) {
        if (permission.getId() == null) {
            permission.setPermission("ROLE_" + permission.getPermission());
            permission = permissionRepository.save(permission);
            return permission;
        } else {
            Optional<Permission> permissionOptional = permissionRepository.findById(permission.getId());
            if (permissionOptional.isPresent()) {
                Permission newPermession = permissionOptional.get();
                newPermession.setId(permission.getId());
                newPermession.setPermission(permission.getPermission());
                return permissionRepository.save(newPermession);
            } else {
                permission = permissionRepository.save(permission);
                return permission;
            }
        }
    }

    @Override
    public RoleApp createOrUpdateRole(RoleApp roleApp) {
        if (roleApp.getId() == null) {
            roleApp = roleRepository.save(roleApp);
            return roleApp;
        } else {
            Optional<RoleApp> roleOptional = roleRepository.findById(roleApp.getId());
            if (roleOptional.isPresent()) {
                RoleApp newRole = roleOptional.get();
                newRole.setId(roleApp.getId());
                newRole.setName("ROLE_" + roleApp.getName());
                newRole.setPermissions(roleApp.getPermissions());
                return roleRepository.save(newRole);
            } else {
                roleApp = roleRepository.save(roleApp);
                return roleApp;
            }
        }
    }
}
