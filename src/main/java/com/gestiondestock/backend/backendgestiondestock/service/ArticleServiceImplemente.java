package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.ArticleRepository;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import com.gestiondestock.backend.enumeration.ETAT_ARTICLE;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
@ToString
public class ArticleServiceImplemente implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;


    //Functioin nous permettant de trouver l'utilisateur connecté
    public User getAuthenticate() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("AUTH ::: {}", auth);
        if (Objects.isNull(auth) || AnonymousAuthenticationToken.class.isAssignableFrom(auth.getClass())) {
            return null;
        }
        //
        log.info("AUTH NAME::: {}", auth.getName());
        Optional<User> userConnecte = userRepository.findByLogin(auth.getName());
        log.info("USER CONNECT::: {}", userConnecte);

        return userConnecte.orElse(null);
    }

    @Override
    public Article saveArticle(Article ar) {
        // TODO Auto-generated method stubf
        //Tester si l'article cree n'est pas null
        if (ar == null) {
            throw new IllegalArgumentException("L'article fourni est null");
        }


        User userConnectSearch = getAuthenticate();

        if (userConnectSearch == null) {
            throw new IllegalArgumentException("user not found !");
        }


        User userConnectSearchFound = userConnectSearch;

        //affecter à l'article l'utilisateur qui l'a connecté !
        ar.setId_USER((int) userConnectSearchFound.getId_USER());


        ar.setEtat_article(ETAT_ARTICLE.ACTIF.name());

        return articleRepository.save(ar);

    }

    @Override
    public Article updateArticle(Article ar) {
        // TODO Auto-generated method stub
        return articleRepository.save(ar);
    }

    @Override
    public Article updateArticleById(Long id, Article article) {
        Optional<Article> articleSearchUp = articleRepository.findById(id);

        if (articleSearchUp.isEmpty()) {
            return null;
        }

        Article articleFound = articleSearchUp.get();
        articleFound.setNom(article.getNom());
        articleFound.setPrix(article.getPrix());
        articleFound.setQte_dispo(article.getQte_dispo());

        System.out.println(article);
        return articleRepository.save(articleFound);
    }

    @Override
    public void deleteArticle(Article ar) {
        // TODO Auto-generated method stub
        ar.setEtat_article(ETAT_ARTICLE.SUPPRIME.name());
        updateArticle(ar);
    }

    @Override
    public void deleteArticleById(Long id) {
        // TODO Auto-generated method stub
        Article ar = getArticle(id);
        ar.setEtat_article(ETAT_ARTICLE.SUPPRIME.name());
        updateArticle(ar);
    }

    @Override
    public Article getArticle(Long id) {
        // TODO Auto-generated method stub
        return articleRepository.findById(id).get();
    }

    @Override
    public List<Article> getAllArticle() {
        // TODO Auto-generated method stub
        return articleRepository.findAll();
    }


    //Rechercher les articles par leurs noms
    @Override
    public List<Article> searchArticlesByName(String nom) {

        return articleRepository.findByNomStartsWith(nom);
    }

}
