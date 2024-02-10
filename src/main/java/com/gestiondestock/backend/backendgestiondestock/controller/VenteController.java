package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.Vente;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;
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

        if (vente == null) {
            throw new IllegalArgumentException("La vente ne doit pas être null!");
        }
        if (vente.getId_vente() != 0) {
            throw new IllegalArgumentException("impossible de creer une vente existente!!!");
        }

        vente.setEtat_vente(ETAT_VENTE.ACTIF.toString());
        return venteService.saveVente(vente);
    }


    @PostMapping("/effectuerVente")
    Vente effectuerVente(@RequestBody List<VenteArticle> va) {
        if (va == null) {
            throw new IllegalArgumentException("Operation non permise; la liste est null, !!");
        }

        if (va.isEmpty()) {
            throw new IllegalArgumentException(" Operation non permise; la liste est vide !!! ");
        }

        return venteService.effectuerVente(va);
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
