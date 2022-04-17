package com.benabdesselam.patientsmvc.repositories;

import com.benabdesselam.patientsmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;




public interface PatientRepository extends JpaRepository<Patient,Long>{
Page<Patient> findByNomContains(String kw,Pageable pageable);
}
