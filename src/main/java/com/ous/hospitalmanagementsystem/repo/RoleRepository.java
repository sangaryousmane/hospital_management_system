package com.ous.hospitalmanagementsystem.repo;


import com.ous.hospitalmanagementsystem.entity.RoleEntity;
import com.ous.hospitalmanagementsystem.utils.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface  RoleRepository extends JpaRepository<RoleEntity, UUID> {

    Optional<RoleEntity> findByRole(RoleName roleName);
}
