package com.benabdesselam.patientsmvc.repositories;

import com.benabdesselam.patientsmvc.entities.Medecin;
import com.benabdesselam.patientsmvc.entities.RendezVous;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
    Page<RendezVous> findByDate(Date date, Pageable pageable);

}
