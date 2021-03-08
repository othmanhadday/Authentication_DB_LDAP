package com.oth.stageapp.service;

import com.oth.stageapp.entities.Permission;
import com.oth.stageapp.entities.RoleApp;
import com.oth.stageapp.entities.UserApp;
import com.oth.stageapp.repositories.RoleRepository;
import com.oth.stageapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserApp addNewUser(UserApp userApp) {
        if (userApp.getId() == null) {
            userApp.setPassword(passwordEncoder.encode("maroclear"));
            userApp.setActivate(true);
            userApp = userRepository.save(userApp);
            return userApp;
        } else {
            Optional<UserApp> userOpt = userRepository.findById(userApp.getId());
            if (userOpt.isPresent()) {
                UserApp user = userOpt.get();
                user.setId(userApp.getId());
                user.setNom(userApp.getNom());
                user.setUsername(userApp.getUsername());
                user.setRoles(userApp.getRoles());
                userApp.setActivate(true);
                user.setPermissions(userApp.getPermissions());
                return userRepository.save(user);
            } else {
                userApp = userRepository.save(userApp);
                return userApp;
            }
        }
    }

    @Override
    public UserApp getUserByUsername(String username) {
        UserApp user = userRepository.findUserAppByUsername(username);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserApp userApp = userRepository.findUserAppByUsername(username);
        if (userApp == null) {
            throw new UsernameNotFoundException("Invalid username password");
        }
        return new User(userApp.getUsername(), userApp.getPassword(), getAuthorities(userApp.getPermissions()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Permission> permissions) {
        return getGrantedAuthorities(permissions);
    }

    private List<GrantedAuthority> getGrantedAuthorities(Collection<Permission> permissions) {
        return permissions.stream().map(permission ->
                new SimpleGrantedAuthority(permission.getPermission())
        ).collect(Collectors.toList());
    }

    private List<String> getPermission(Collection<RoleApp> roles) {
        List<String> permissions = new ArrayList<>();
        List<Permission> collection = new ArrayList<>();
        for (RoleApp role : roles) {
            collection.addAll(role.getPermissions());
        }
        for (Permission permission : collection) {
            permissions.add(permission.getPermission());
        }
        return permissions;
    }
}
