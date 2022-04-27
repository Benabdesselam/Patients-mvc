package com.benabdesselam.patientsmvc.security.service;

import com.benabdesselam.patientsmvc.security.entities.AppRole;
import com.benabdesselam.patientsmvc.security.entities.AppUser;
import com.benabdesselam.patientsmvc.security.repositories.AppRoleRepository;
import com.benabdesselam.patientsmvc.security.repositories.AppUserRepository;
import groovy.util.logging.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;


    public SecurityServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if(password.equals(rePassword)) throw new RuntimeException("Password not match");
         String hashedPWD=passwordEncoder.encode(password);
         AppUser appUser=new AppUser();
         appUser.setUserid(UUID.randomUUID().toString());
         appUser.setUsername(username);
         appUser.setPassword(password);
         appUser.setActive(true);
        AppUser savedAppUser= appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleNAme, String description) {

       AppRole appRole1= appRoleRepository.findByRoleName(roleNAme);

        if(appRole1!=null) throw new RuntimeException("Role"+roleNAme+"Already exist!");
       appRole1=new AppRole();
        appRole1.setRoleName(roleNAme);
        appRole1.setDescription(description);
       AppRole savedAppRole= appRoleRepository.save(appRole1);
        return savedAppRole;
    }

    @Override
    public Void addRoleToUser(String username, String roleName) {
        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException("User not Found");
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException("Role not Found");

        appUser.getAppRoles().add(appRole);


        return null;
    }

    @Override
    public Void removeRoleFromUser(String username, String roleName) {
        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException("User not Found");
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException("Role not Found");

        appUser.getAppRoles().remove(appRole);
        return null;
    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }
}
