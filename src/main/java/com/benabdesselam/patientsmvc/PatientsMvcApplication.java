package com.benabdesselam.patientsmvc;

import com.benabdesselam.patientsmvc.entities.Patient;
import com.benabdesselam.patientsmvc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

     //@Bean
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
}
