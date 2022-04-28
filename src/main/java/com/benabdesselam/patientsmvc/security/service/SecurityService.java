package com.benabdesselam.patientsmvc.security.service;


import com.benabdesselam.patientsmvc.security.entities.AppRole;
import com.benabdesselam.patientsmvc.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username , String password , String password2);
    AppRole saveNewRole(String roleName , String description);
    void addRoleToUSer(String usernmae, String roleName);
    void removeRoleFromUSer(String usernmae, String roleName);
    AppUser loadUserByUserName(String username);
}
