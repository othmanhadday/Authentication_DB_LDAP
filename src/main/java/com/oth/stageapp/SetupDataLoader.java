package com.oth.stageapp;

import com.oth.stageapp.entities.Permission;
import com.oth.stageapp.entities.RoleApp;
import com.oth.stageapp.entities.UserApp;
import com.oth.stageapp.repositories.PermissionRepository;
import com.oth.stageapp.repositories.RoleRepository;
import com.oth.stageapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;


    @Transactional
    public Permission createPermission(String name) {
        Permission permission = permissionRepository.findPermissionByPermission(name);
        if (permission == null) {
            permission = new Permission(null, name);
            return permissionRepository.save(permission);
        }
        return permission;
    }

    @Transactional
    public RoleApp createRole(String name, Collection<Permission> permissions) {
        RoleApp role = roleRepository.findRoleAppByName(name);
        if (role == null) {
            role = new RoleApp(null, name, permissions);
            return roleRepository.save(role);
        }
        return role;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }
//        Permission readPermission = createPermission("READ_PERMISSION");
//        Permission writePermission = createPermission("WRITE_PERMISSION");
//
//        List<Permission> adminPermission = Arrays.asList(readPermission, writePermission);
//        createRole("ROLE_USER", Arrays.asList(readPermission));
//        createRole("ROLE_ADMIN", adminPermission);

//        RoleApp adminRole = roleRepository.findRoleAppByName("ROLE_USER");
//        UserApp user = new UserApp();
//        user.setNom("Test");
//        user.setPassword(passwordEncoder.encode("test"));
//        user.setUsername("oth@test.com");
//        user.setRoles(Arrays.asList(adminRole));
//        userRepository.save(user);

        alreadySetup = true;
    }
}
