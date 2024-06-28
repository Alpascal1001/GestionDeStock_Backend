package com.gestiondestock.backend.backendgestiondestock.repo;

import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VenteArticleRepository extends JpaRepository<VenteArticle, Long> {

    @Query(value = "SELECT SUM(va.quantite_vente_article) FROM vente_article va;", nativeQuery = true)
    Integer findArticleTotalAmount();

    @Query(value = "SELECT SUM(va.total_vente_article) FROM vente_article va;", nativeQuery = true)
    Double findArticleTotalPrice();
}
