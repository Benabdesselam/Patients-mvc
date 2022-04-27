package com.benabdesselam.patientsmvc.security.service;

import com.benabdesselam.patientsmvc.security.entities.AppRole;
import com.benabdesselam.patientsmvc.security.entities.AppUser;

public interface SecurityService {

    AppUser saveNewUser(String username,String password,String rePassword);
    AppRole saveNewRole(String roleNAme,String description);
    Void addRoleToUser(String username,String roleName);
    Void removeRoleFromUser(String username,String roleName);
     AppUser loadUserByUserName(String username);

}
