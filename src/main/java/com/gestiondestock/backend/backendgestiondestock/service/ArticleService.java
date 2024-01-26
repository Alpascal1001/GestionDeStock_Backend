package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;

import java.util.List;


public interface ArticleService {


    Article saveArticle(Article ar);

    Article updateArticle(Article ar);

    void deleteArticle(Article ar);

    void deleteArticleById(Long id);

    Article getArticle(Long id);

    List<Article> getAllArticle();

}
