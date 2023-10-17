package com.habsida.crudmvc.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<User> users;

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
