package com.gestiondestock.backend.backendgestiondestock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondestock.backend.backendgestiondestock.entity.Vente;

public interface VenteRepository extends JpaRepository<Vente, Long> {

}
