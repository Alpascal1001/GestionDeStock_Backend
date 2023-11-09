package com.gestiondestock.backend.backendgestiondestock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
