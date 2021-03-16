package com.oth.stageapp.controller;

import com.oth.stageapp.PasswordEncoder;
import com.oth.stageapp.entities.UserApp;
import com.oth.stageapp.repositories.PermissionRepository;
import com.oth.stageapp.repositories.RoleRepository;
import com.oth.stageapp.repositories.UserRepository;
import com.oth.stageapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

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
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @RequestMapping
    public String index(Model model) {
        List<UserApp> usersActivated = userRepository.findUserAppsByActivateTrueAndDeletedFalse();
        List<UserApp> usersNotActivated = userRepository.findUserAppsByActivateFalseAndDeletedFalse();
        model.addAttribute("usersActivated", usersActivated);
        model.addAttribute("usersNotActivated", usersNotActivated);
        model.addAttribute("user", new UserApp());
        model.addAttribute("allRoles", roleRepository.findRoleAppsByDeletedFalse());
        model.addAttribute("allPermissions", permissionRepository.findAll());
        return "users";
    }

    @PostMapping("/createOrUpdateUser")
    public String createOrUpdateUser(@ModelAttribute("user") UserApp userApp) {
        userService.addNewUser(userApp);
        return "redirect:/user";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Optional<Long> id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping("/reinitialiser/{id}")
    public String reinitialiserPwd(@PathVariable Optional<Long> id, Model model, RedirectAttributes redirAttrs) {
        Map<String, UserApp> map = new HashMap<String, UserApp>();
        map = userService.reinitialiserPwd(id);
        String pwd = "";
        Iterator<String> passwords = map.keySet().iterator();
        while (passwords.hasNext()) {
            pwd = passwords.next();
        }
        redirAttrs.addFlashAttribute("passwordGenerer", pwd);
        redirAttrs.addFlashAttribute("userNom", map.get(pwd).getNom());

        return "redirect:/user";
    }
}
