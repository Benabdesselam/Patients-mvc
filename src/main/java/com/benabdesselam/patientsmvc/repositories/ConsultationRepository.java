package com.benabdesselam.patientsmvc.repositories;

import com.benabdesselam.patientsmvc.entities.Consultation;
import com.benabdesselam.patientsmvc.entities.RendezVous;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
   // Page<Consultation> findByNomContains(String keyword, Pageable pageable);

}
