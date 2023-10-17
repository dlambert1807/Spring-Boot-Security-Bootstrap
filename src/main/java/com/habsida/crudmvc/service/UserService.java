package com.habsida.crudmvc.service;

import com.habsida.crudmvc.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User u);

    void deleteById(long id);

    List<User> listUsers();

    User getUser(long id);

    void updateUser(User user);

    User findByEmail(String email);

}
