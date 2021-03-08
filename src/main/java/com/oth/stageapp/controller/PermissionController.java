package com.oth.stageapp.controller;

import com.oth.stageapp.entities.Permission;
import com.oth.stageapp.entities.RoleApp;
import com.oth.stageapp.repositories.PermissionRepository;
import com.oth.stageapp.repositories.RoleRepository;
import com.oth.stageapp.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        List<RoleApp> roles = roleRepository.findAll();
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
}
