package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.Etatdecaisse;
import com.gestiondestock.backend.backendgestiondestock.service.EtatdecaisseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/etatdecaisse")
public class EtatdecaisseController {
    @Autowired
    private EtatdecaisseService etatdecaisseService;

    @GetMapping("/listEtatdecaisse")
    public List<Etatdecaisse> listEtatdecaisse() {
        return etatdecaisseService.getAllEtatdecaisse();
    }

    @PostMapping("/addEtatdecaisse")
    public Etatdecaisse addEtatdecaisse(@RequestBody Etatdecaisse etatdecaisse) {
        return etatdecaisseService.saveEtatdecaisse(etatdecaisse);
    }

    @PutMapping("/updateEtatdecaisse")
    public Etatdecaisse updateEtatdecaisse(@RequestBody Etatdecaisse etatdecaisse) {
        return etatdecaisseService.updateEtatdecaisse(etatdecaisse);
    }

    @DeleteMapping("/deleteEtatdecaisse/{id}")
    public void deleteEtatdecaisse(@PathVariable Long id) {
        etatdecaisseService.deleteEtatdecaisseById(id);
    }
}
