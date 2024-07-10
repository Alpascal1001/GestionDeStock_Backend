package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.entity.Vente;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;
import com.gestiondestock.backend.backendgestiondestock.repo.ArticleRepository;
import com.gestiondestock.backend.backendgestiondestock.repo.VenteArticleRepository;
import com.gestiondestock.backend.backendgestiondestock.repo.VenteRepository;
import com.gestiondestock.backend.backendgestiondestock.service.getUserAuth.GetUserAuthService;
import com.gestiondestock.backend.enumeration.ETAT_USER;
import com.gestiondestock.backend.enumeration.ETAT_VENTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VenteServiceImp implements VenteService {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    VenteArticleRepository venteArticleRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    private GetUserAuthService getUserAuthService;

    @Override
    public Vente saveVente(Vente v) {
        // TODO Auto-generated method stub
        return venteRepository.save(v);
    }

    @Override
    public Vente updateVente(Vente v) {
        // TODO Auto-generated method stub
        return saveVente(v);
    }

    @Override
    public Vente upddateVenteById(Long id, Vente vente) {
        Optional<Vente> venteSearched = venteRepository.findById(id);

        if (venteSearched.isEmpty()) {
            return null;
        }

        Vente venteFound = venteSearched.get();
        venteFound.setDate_vente(vente.getDate_vente());
        venteFound.setDate_annulation(vente.getDate_annulation());
        venteFound.setEtat_vente(vente.getEtat_vente());

        return venteFound;
    }


    @Override
    public void deleteVente(Vente v) {
        // TODO Auto-generated method stub
        v.setEtat_vente(ETAT_VENTE.ANNULATION.name());
        updateVente(v);
    }

    @Override
    public void deleteVenteById(Long id) {
        // TODO Auto-generated method stub
        Vente v = getVente(id);
        v.setEtat_vente(ETAT_VENTE.ANNULATION.name());
        updateVente(v);
    }

    @Override
    public Vente getVente(Long id) {
        // TODO Auto-generated method stub
        return venteRepository.findById(id).get();
    }

    @Override
    public List<Vente> getAllVente() {
        // TODO Auto-generated method stub
        return venteRepository.findAll();
    }

    @Override
    @Transactional
    public Vente effectuerVente(List<VenteArticle> venteArticles) {
        //creer la vente

        Vente v = new Vente();
        v.setDate_vente(new Date());
        v.setEtat_vente(ETAT_VENTE.INACTIF.toString()); //à l'initial l'etat vente est innactif

        User userAuthSearchFound = getUserAuthService.getAuthenticate();
        if (userAuthSearchFound == null) {
            return null;
        }

        //Recuperer l'identifiant de l'utilisateur connecté !
        v.setId_USER((int) userAuthSearchFound.getId_USER());

        //Tester si l'utilisateur est Actif
        if (!userAuthSearchFound.getEtat().equals(ETAT_USER.ACTIF.toString())) {
            throw new IllegalArgumentException("L'utilisateur Connecté doit etre " + ETAT_USER.ACTIF);
        }

        v = venteRepository.save(v);


        //boucler sur la liste
        for (VenteArticle va : venteArticles) {
            //setter l'id de la vente créée
            va.setId_vente(v.getId_vente());
            va.setEtat_vente_article(ETAT_VENTE.ACTIF.toString());
            //Enregistrer la vente d'articles effectuée
            venteArticleRepository.save(va);

            //decrementer la quantite de stock disponible au niveau de l'article
            //Trouver l'article d'abord
            Optional<Article> article = articleRepository.findById((long) va.getId_article());

            if (article.isEmpty()) {
                //mettre à l'article à null
                v.setEtat_vente(ETAT_VENTE.ANNULATION.toString());
                venteRepository.save(v);
                throw new IllegalArgumentException(" L'article d'identifiant " + va.getId_article() + " est introuvable !!!");
            }

            Article articleFound = article.get();

            //Tester si l'etat est actif
            if (!articleFound.getEtat_article().equals(ETAT_VENTE.ACTIF.toString())) {
                //annuler la vente avant de lancer l'exception
                v.setEtat_vente(ETAT_VENTE.ANNULATION.toString());
                venteRepository.save(v);
                throw new IllegalArgumentException(" L'article d'identifiant " + va.getId_article() + " n'est pas ACTIF !!!");
            }
            //Tester si la quantité qu'on veut vendre est disponible
            if (articleFound.getQte_dispo() < va.getQuantite_vente_article()) {
                //annuler la vente avant de lancer l'exception
                v.setEtat_vente(ETAT_VENTE.ANNULATION.toString());
                venteRepository.save(v);
                throw new IllegalArgumentException(" L'article d'identifiant " + va.getId_article() + " n'est pas disponible avec la quantité souhaitée !!!");
            }

            articleFound.setQte_dispo((int) (articleFound.getQte_dispo() - va.getQuantite_vente_article()));


            //Recuperer la quantité et le prix de l'article et le multiplié pour ensuite le setter dans le total
            //va.setTotal_vente_article(articleFound.getQte_dispo() * articleFound.getPrix());
            va.setMontant_vente_article(articleFound.getPrix());

            va.setTotal_vente_article(va.getQuantite_vente_article() * articleFound.getPrix());

            //updateVente(v);
            //enteArticleRepository.save(va);


            //Ensuite sauvegarder
            articleRepository.save(articleFound);


        }
        //tout est ok
        v.setEtat_vente(ETAT_VENTE.ACTIF.toString());

        //afficher la vente
        return v;


    }

}
