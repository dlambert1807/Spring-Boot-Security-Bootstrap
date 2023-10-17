package com.habsida.crudmvc.service;

import com.habsida.crudmvc.entity.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);

    void deleteById(long id);

    List<Role> listRoles();

    Role getRole(long id);

    void updateRole(Role role);

}
