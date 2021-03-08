package com.oth.stageapp.service;

import com.oth.stageapp.entities.Permission;
import com.oth.stageapp.entities.RoleApp;

public interface AuthorityService {
    Permission createOrUpdatePermission(Permission permission);

    RoleApp createOrUpdateRole(RoleApp roleApp);
}
