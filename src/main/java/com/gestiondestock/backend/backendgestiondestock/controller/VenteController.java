package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.entity.Vente;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import com.gestiondestock.backend.backendgestiondestock.service.VenteService;
import com.gestiondestock.backend.enumeration.ETAT_USER;
import com.gestiondestock.backend.enumeration.ETAT_VENTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventes")
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private UserRepository userRepository;

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


    @PostMapping("/effectuerVente/{idUser}")
    Vente effectuerVente(@PathVariable Long idUser, @RequestBody List<VenteArticle> va) {
        if (va == null) {
            throw new IllegalArgumentException("Operation non permise; la liste est null, !!");
        }

        if (va.isEmpty()) {
            throw new IllegalArgumentException(" Operation non permise; la liste est vide !!! ");
        }
        //Tester si l'identifiant est 0
        if (idUser == 0) {
            throw new IllegalArgumentException(" Merci de founir un utilisateur !!!");
        }
        Optional<User> userSearched = userRepository.findById(idUser);

        //Tester si l'utilisateur existe
        if (userSearched.isEmpty()) {
            throw new IllegalArgumentException(" L'utilisateur d'identifiant " + idUser + " n'existe pas !!!");
        }

        //Tester si l'utilisateur existe mais pas actif
        User userFound = userSearched.get();
        if (!userFound.getEtat().equals(ETAT_USER.ACTIF.toString())) {
            throw new IllegalArgumentException(" L'utilisateur d'identifiant " + idUser + " n'est pas " + ETAT_USER.ACTIF);
        }

        return venteService.effectuerVente(va, idUser);
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
