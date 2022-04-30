package com.benabdesselam.patientsmvc.web;

import com.benabdesselam.patientsmvc.entities.Consultation;
import com.benabdesselam.patientsmvc.entities.Medecin;
import com.benabdesselam.patientsmvc.entities.Patient;
import com.benabdesselam.patientsmvc.entities.RendezVous;
import com.benabdesselam.patientsmvc.repositories.ConsultationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class ConsultationController {
 private ConsultationRepository consultationRepository;

    @GetMapping(path = "/user/listConsultations")
    @ResponseBody
    public List<Consultation> listConsultations(){
        return  consultationRepository.findAll();
    }
    @GetMapping(path = "/user/consult")
    public String consultations(Model model){
          // Page<Consultation> pageConsultations = consultationRepository.findByDateConsultation(date,PageRequest.of(page,size));
            model.addAttribute("listConsultations" ,listConsultations());
          //  model.addAttribute("pages",new int[pageConsultations.getTotalPages()] );
         //   model.addAttribute("currentPage",page);
          //  model.addAttribute("date",date);
            return "consultations";
    }
}
