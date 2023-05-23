package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public Set<Role> getRoles(Long [] ides) {
        Set <Role> roles = new HashSet<>();
        for (int i = 0; i < ides.length; i++) {
            roles.add(roleDao.getById(ides[i]));
        }
        return roles;
    }
}