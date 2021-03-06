package com.oth.stageapp.controller;

import com.oth.stageapp.entities.RoleApp;
import com.oth.stageapp.entities.UserApp;
import com.oth.stageapp.repositories.RoleRepository;
import com.oth.stageapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RestUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/user/{id}")
    public Optional<UserApp> getUserById(@PathVariable Optional<Long> id) {
        return userRepository.findById(id);
    }

    @GetMapping("/role/{id}")
    public Optional<RoleApp> getGetById(@PathVariable Optional<Long> id) {

        System.out.println(roleRepository.findById(id).get());

        return roleRepository.findById(id);
    }

    @GetMapping("/roles/{id}")
    public List<UserApp> getUserByRole(@PathVariable Optional<Long> id){
        RoleApp roleApp = roleRepository.findById(id).get();
        return userRepository.findUserAppsByRolesAndActivateTrueAndDeletedFalse(roleApp);
    }


}
