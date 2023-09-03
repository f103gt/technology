package com.technology.registration.services.role.strategy;

import com.technology.registration.repositories.UserRepository;

public interface RoleStrategy {
    void addRole(UserRepository userRepository, String username);
    void deleteRole(UserRepository userRepository, String username);
}
