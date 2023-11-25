package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestiondestock.backend.backendgestiondestock.entity.Etatdecaisse;
import com.gestiondestock.backend.backendgestiondestock.repo.EtatdecaisseRepository;
import com.gestiondestock.backend.enumeration.ETAT_ETATDECAISSE;

public class EtatdecaisseServiceImp implements EtatdecaisseService {

	@Autowired
	EtatdecaisseRepository etatdecaisseRepository;
	@Override
	public Etatdecaisse saveEtatdecaisse(Etatdecaisse ec) {
		// TODO Auto-generated method stub
		return  etatdecaisseRepository.save(ec);
	}

	@Override
	public Etatdecaisse updateEtatdecaisse(Etatdecaisse ec) {
		// TODO Auto-generated method stub
		return saveEtatdecaisse(ec);
	}

	@Override
	public void deleteEtatdecaisse(Etatdecaisse ec) {
		// TODO Auto-generated method stub
		ec.setEtat(ETAT_ETATDECAISSE.ANNULATION.name());
		 updateEtatdecaisse(ec);
	}

	@Override
	public void deleteEtatdecaisseById(Long id) {
		// TODO Auto-generated method stub
		Etatdecaisse ec = getEtatdecaisse(id);
		ec.setEtat(ETAT_ETATDECAISSE.ANNULATION.name());
		 updateEtatdecaisse(ec);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Etatdecaisse getEtatdecaisse(Long id) {
		// TODO Auto-generated method stub
		return  etatdecaisseRepository.getById(id);
	}

	@Override
	public List<Etatdecaisse> getAllEtatdecaisse() {
		// TODO Auto-generated method stub
		return etatdecaisseRepository.findAll();
	}

}
