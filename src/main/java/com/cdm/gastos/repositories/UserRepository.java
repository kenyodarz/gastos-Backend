package com.cdm.gastos.repositories;

import com.cdm.gastos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByUsername (String username);

    Boolean existsByUsername(String usename);

    Boolean existsByEmail(String email);
}
