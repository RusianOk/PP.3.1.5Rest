package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

public interface RoleService {

    void add (Role role);
    Role getById (Long id);
    Set<Role> getRoles(Long [] ides);
}
