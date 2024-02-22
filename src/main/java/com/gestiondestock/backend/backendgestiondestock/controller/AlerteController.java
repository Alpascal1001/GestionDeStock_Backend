package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.Alerte;
import com.gestiondestock.backend.backendgestiondestock.service.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertes")
public class AlerteController {
    @Autowired
    private AlerteService alerteService;

    @GetMapping("/listAlerte")
    public List<Alerte> listAlerte() {
        return alerteService.listeAlerte();
    }

    @PostMapping("/addAlerte")
    public Alerte addAlerte(@RequestBody Alerte al) {
        return alerteService.addAler(al);
    }

    @PutMapping("/updateAlert")
    public Alerte updateAlerte(@RequestBody Alerte alerte) {
        return alerteService.updateAlerte(alerte);
    }

    @DeleteMapping("/deleteAlerte/{id}")
    public void deleteAlerteById(@PathVariable Long id) {
        alerteService.deleteAlerteById(id);
    }

}
