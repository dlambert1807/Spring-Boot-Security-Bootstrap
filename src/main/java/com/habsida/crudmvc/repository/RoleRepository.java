package com.habsida.crudmvc.repository;

import com.habsida.crudmvc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
