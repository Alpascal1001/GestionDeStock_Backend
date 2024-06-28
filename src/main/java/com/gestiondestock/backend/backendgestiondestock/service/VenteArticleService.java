package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.dto.VenteArticleDTO;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;

import java.util.List;

public interface VenteArticleService {


    VenteArticle saveVenteArticle(VenteArticle va);

    VenteArticle updateVenteArticle(VenteArticle va);

    void deleteVenteArticle(VenteArticle va);

    void deleteVenteArticleById(Long id);

    VenteArticle findVenteArticle(Long id);

    List<VenteArticle> findAllVenteArticle();


    //Calcul de la quantite totale des articles
    VenteArticleDTO getArticleTotalAmountAndPrice();

    //Calcul du prix total des articles
    //VenteArticleDTO getArticleTotalPrice();
}
