package com.globant.MessageService.auth.repositories;

import com.globant.MessageService.auth.entities.ERole;
import com.globant.MessageService.auth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}