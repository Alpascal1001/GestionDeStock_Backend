package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Alerte;
import com.gestiondestock.backend.backendgestiondestock.repo.AlerteRepository;
import com.gestiondestock.backend.enumeration.ETAT_ALERT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlerteServiceImp implements AlerteService {
    @Autowired
    AlerteRepository alerteRepository;

    @Override
    public List<Alerte> listeAlerte() {
        return alerteRepository.findAll();
    }

    @Override
    public Alerte addAler(Alerte alerte) {
        alerte.setEtat_alert(ETAT_ALERT.ACTIF.toString());
        return alerteRepository.save(alerte);
    }

    @Override
    public Alerte updateAlerte(Alerte alerte) {
        return alerteRepository.save(alerte);
    }

    @Override
    public void deleteAlerte(Alerte alerte) {
        alerteRepository.delete(alerte);
    }

    public Alerte getAnAlert(Long id) {
        return alerteRepository.findById(id).get();
    }

    @Override
    public void deleteAlerteById(Long id) {
        Alerte alert = getAnAlert(id);
        alert.setEtat_alert(ETAT_ALERT.INACTIF.toString());
        updateAlerte(alert);
    }
}
