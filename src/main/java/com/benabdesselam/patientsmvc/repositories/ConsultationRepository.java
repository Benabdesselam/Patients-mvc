package com.benabdesselam.patientsmvc.repositories;

import com.benabdesselam.patientsmvc.entities.Consultation;
import com.benabdesselam.patientsmvc.entities.RendezVous;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
