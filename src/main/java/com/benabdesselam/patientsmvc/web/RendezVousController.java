package com.benabdesselam.patientsmvc.web;

import com.benabdesselam.patientsmvc.entities.RendezVous;
import com.benabdesselam.patientsmvc.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RendezVousController {
    private RendezVousRepository rendezVousRepository;
    @Autowired
    @GetMapping(path = "/user/rdvs")
    @ResponseBody
    public List<RendezVous> listRDVs(){
        return  rendezVousRepository.findAll();
    }

    @GetMapping(path = "/user/karim")
    public String rendezvous(Model model){
      model.addAttribute("listRDVs",listRDVs());
        return "rendezvous";
    }

}
