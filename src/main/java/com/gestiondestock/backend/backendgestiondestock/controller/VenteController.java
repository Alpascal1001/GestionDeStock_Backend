package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.Vente;
import com.gestiondestock.backend.backendgestiondestock.service.VenteService;
import com.gestiondestock.backend.enumeration.ETAT_VENTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventes")
public class VenteController {
    @Autowired
    private VenteService venteService;

    @PostMapping("/createVente")
    public Vente addVente(@RequestBody Vente vente) {
        vente.setEtat_vente(ETAT_VENTE.ACTIF.toString());
        return venteService.saveVente(vente);
    }

    @GetMapping("/listeVente")
    public List<Vente> listeVentes() {
        return venteService.getAllVente();
    }

    @PutMapping("/updateVente")
    public Vente updateVente(@RequestBody Vente vente) {
        return venteService.updateVente(vente);
    }

    @DeleteMapping("/deleteVente/{id}")
    public void deleteVente(@PathVariable Long id) {
        venteService.deleteVenteById(id);
    }
}
