package com.gestiondestock.backend.backendgestiondestock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondestock.backend.backendgestiondestock.entity.Alerte;

public interface AlerteRepository extends JpaRepository<Alerte, Long> {

}
