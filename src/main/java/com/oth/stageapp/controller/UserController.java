package com.oth.stageapp.controller;

import com.oth.stageapp.entities.Permission;
import com.oth.stageapp.entities.RoleApp;
import com.oth.stageapp.entities.UserApp;
import com.oth.stageapp.repositories.PermissionRepository;
import com.oth.stageapp.repositories.RoleRepository;
import com.oth.stageapp.repositories.UserRepository;
import com.oth.stageapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UserService userService;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("user", new UserApp());
        model.addAttribute("allRoles", roleRepository.findAll());
        model.addAttribute("allPermissions", permissionRepository.findAll());
        return "users";
    }

    @PostMapping("/createOrUpdateUser")
    public String createOrUpdateUser(@ModelAttribute("user") UserApp userApp) {
        System.out.println(userApp);
        userService.addNewUser(userApp);
        return "redirect:/user";
    }


}
