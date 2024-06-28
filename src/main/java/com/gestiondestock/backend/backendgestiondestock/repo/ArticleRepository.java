package com.gestiondestock.backend.backendgestiondestock.repo;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByNomStartsWith(String nom);
}
