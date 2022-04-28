package com.benabdesselam.patientsmvc;

import com.benabdesselam.patientsmvc.entities.Patient;
import com.benabdesselam.patientsmvc.repositories.PatientRepository;
import com.benabdesselam.patientsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    // @Bean

    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
      return args -> {
        patientRepository.save(new Patient(null,"benabdesselam",new Date(),true,550));
         patientRepository.save(new Patient(null,"karim",new Date(),true,300));
          patientRepository.save(new Patient(null,"ismail",new Date(),true,400));
          patientRepository.save(new Patient(null,"reda",new Date(),true,800));
          patientRepository.findAll().forEach(patient ->{
                      System.out.println(patient.getNom()+"--------");
              System.out.println("===========================");
                  }
          );
      };
    };

//@Bean
CommandLineRunner saveUsers(SecurityService securityService){
    return args -> {
     securityService.saveNewUser("abdo","1234","1234");
//     securityService.saveNewUser("fox","1234","1234");
//     securityService.saveNewUser("reda","1234","1234");

     securityService.saveNewRole("USER","");
     securityService.saveNewRole("ADMIN","");

     securityService.addRoleToUSer("abdo","USER");
     securityService.addRoleToUSer("abdo","ADMIN");
//       securityService.addRoleToUser("reda","USER");


    };

}

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
