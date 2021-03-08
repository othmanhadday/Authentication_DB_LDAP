package com.oth.stageapp.service;

import com.oth.stageapp.entities.UserApp;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserApp addNewUser(UserApp userApp);

    UserApp getUserByUsername(String username);

}
