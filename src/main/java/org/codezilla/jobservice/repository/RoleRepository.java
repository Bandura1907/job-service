package org.codezilla.jobservice.repository;

import org.codezilla.jobservice.models.ERole;
import org.codezilla.jobservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
