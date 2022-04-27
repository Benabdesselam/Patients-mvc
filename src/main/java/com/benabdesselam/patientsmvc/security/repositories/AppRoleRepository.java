package com.benabdesselam.patientsmvc.security.repositories;

import com.benabdesselam.patientsmvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
AppRole findByRoleName(String roleName);

}
