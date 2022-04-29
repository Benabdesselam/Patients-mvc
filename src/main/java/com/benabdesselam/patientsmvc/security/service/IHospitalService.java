package com.benabdesselam.patientsmvc.security.service;

import com.benabdesselam.patientsmvc.entities.Consultation;
import com.benabdesselam.patientsmvc.entities.Medecin;
import com.benabdesselam.patientsmvc.entities.Patient;
import com.benabdesselam.patientsmvc.entities.RendezVous;


public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedcin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);


}
