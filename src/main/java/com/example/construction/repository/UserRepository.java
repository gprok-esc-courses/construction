package com.example.construction.repository;

import com.example.construction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Set<User> findAllByRole(String role);
}
