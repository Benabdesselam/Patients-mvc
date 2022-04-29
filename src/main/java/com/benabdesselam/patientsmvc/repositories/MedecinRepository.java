package com.benabdesselam.patientsmvc.repositories;

import com.benabdesselam.patientsmvc.entities.Medecin;
import com.benabdesselam.patientsmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Page<Medecin> findByNomContains(String kw, Pageable pageable);

}
