package com.gestiondestock.backend.backendgestiondestock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;

public interface VenteArticleRepository extends JpaRepository<VenteArticle, Long> {

}
