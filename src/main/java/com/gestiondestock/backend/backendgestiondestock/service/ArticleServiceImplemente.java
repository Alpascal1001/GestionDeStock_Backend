package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.repo.ArticleRepository;
import com.gestiondestock.backend.enumeration.ETAT_ARTICLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImplemente implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article ar) {
        // TODO Auto-generated method stubf
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
