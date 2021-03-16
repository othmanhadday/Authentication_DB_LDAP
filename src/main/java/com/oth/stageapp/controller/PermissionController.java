package com.oth.stageapp.controller;

import com.oth.stageapp.entities.Permission;
import com.oth.stageapp.entities.RoleApp;
import com.oth.stageapp.repositories.PermissionRepository;
import com.oth.stageapp.repositories.RoleRepository;
import com.oth.stageapp.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/autorisation")
public class PermissionController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping
    public String showPermission(Model model) {
        List<RoleApp> roles = roleRepository.findRoleAppsByDeletedFalse();
        List<Permission> permissions = permissionRepository.findAll();
        model.addAttribute("role", new RoleApp());
        model.addAttribute("permissionApp", new Permission());
        model.addAttribute("allRoles", roles);
        model.addAttribute("allPermissions", permissions);
        return "permission";
    }

    @PostMapping("/role")
    public String CreateOrUpdateRole(@ModelAttribute("role") RoleApp role) {
        authorityService.createOrUpdateRole(role);
        return "redirect:/autorisation";
    }

    @PostMapping("/permission")
    public String CreateOrUpdatePermission(@ModelAttribute("permissionApp") Permission permission) {
        authorityService.createOrUpdatePermission(permission);
        return "redirect:/autorisation";
    }

    @GetMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable Optional<Long> id) {
        RoleApp roleApp = roleRepository.findById(id).get();
        roleApp.setDeleted(true);
        authorityService.createOrUpdateRole(roleApp);
        return "redirect:/autorisation";
    }
}
