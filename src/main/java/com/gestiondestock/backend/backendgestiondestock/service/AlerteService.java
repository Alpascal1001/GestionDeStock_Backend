package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Alerte;

import java.util.List;

public interface AlerteService {

    List<Alerte> listeAlerte();

    Alerte addAler(Alerte alerte);

    Alerte updateAlerte(Alerte alerte);

    void deleteAlerte(Alerte alerte);

    void deleteAlerteById(Long id);

}
