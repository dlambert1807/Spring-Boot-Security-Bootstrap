package com.habsida.crudmvc.service;

import com.habsida.crudmvc.entity.Role;
import com.habsida.crudmvc.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }
}
