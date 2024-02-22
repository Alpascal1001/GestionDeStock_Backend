package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.entity.Vente;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;
import com.gestiondestock.backend.backendgestiondestock.repo.ArticleRepository;
import com.gestiondestock.backend.backendgestiondestock.repo.VenteArticleRepository;
import com.gestiondestock.backend.backendgestiondestock.repo.VenteRepository;
import com.gestiondestock.backend.enumeration.ETAT_VENTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Vente effectuerVente(List<VenteArticle> venteArticles) {
        //creer la vente

        Vente v = new Vente();
        v.setDate_vente(new Date());
        v.setEtat_vente(ETAT_VENTE.ACTIF.toString());

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


            //Ensuite sauvegarder
            articleRepository.save(articleFound);
        }

        //afficher la vente
        return v;


    }

}
