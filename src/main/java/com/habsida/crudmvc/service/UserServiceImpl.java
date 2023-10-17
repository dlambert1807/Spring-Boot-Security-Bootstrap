package com.habsida.crudmvc.service;

import com.habsida.crudmvc.entity.User;
import com.habsida.crudmvc.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
