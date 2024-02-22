package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Vente;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;

import java.util.List;


public interface VenteService {

    Vente saveVente(Vente v);

    Vente updateVente(Vente v);

    void deleteVente(Vente v);

    void deleteVenteById(Long id);

    Vente getVente(Long id);

    List<Vente> getAllVente();

    Vente effectuerVente(List<VenteArticle> venteArticles);


}
