package com.gestiondestock.backend.backendgestiondestock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondestock.backend.backendgestiondestock.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
