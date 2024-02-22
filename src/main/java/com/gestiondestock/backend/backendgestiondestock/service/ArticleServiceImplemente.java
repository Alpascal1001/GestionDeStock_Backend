package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.entity.User;
import com.gestiondestock.backend.backendgestiondestock.repo.ArticleRepository;
import com.gestiondestock.backend.backendgestiondestock.repo.UserRepository;
import com.gestiondestock.backend.enumeration.ETAT_ARTICLE;
import com.gestiondestock.backend.enumeration.ETAT_USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImplemente implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Article saveArticle(Article ar) {
        // TODO Auto-generated method stubf
        //Tester si l'article cree n'est pas null
        if (ar == null) {
            throw new IllegalArgumentException("L'article fourni est null");
        }

        //Tester si l'article est affecte à un utilisateur
        if (ar.getId_USER() == 0) {
            throw new IllegalArgumentException("L'article fourni doit etre raccorde à un utilisateur valide");
        }

        //chercher l'existence de l'utilisateur dans la base de donnee
        Optional<User> userFound = userRepository.findById((long) ar.getId_USER()); //recherche de la category            //transtypage primitif en primitif

        //Tester si l'utlisateur existe
        if (userFound.isEmpty()) {
            throw new IllegalArgumentException("L'utilisateur fourni n'existe pas !!!");
        }

        //System.out.println(userFound.get());

        //Test si l'article est affecté à un utilisateur actif
        if (!userFound.get().getEtat().equals(ETAT_USER.ACTIF.toString())) {
            throw new IllegalArgumentException(" L'utilisateur fourni doit etre actif !!! ");
        }

        ar.setEtat_article(ETAT_ARTICLE.ACTIF.name());
        return articleRepository.save(ar);

    }

    @Override
    public Article updateArticle(Article ar) {
        // TODO Auto-generated method stub
        return articleRepository.save(ar);
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

}
