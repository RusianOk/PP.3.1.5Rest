package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User add (User user);
    User update (User user, Long id);
    void delete (Long id);
    List<User> getAllUsers();
    User getById (Long id);
    User findByUsername (String username);
}