package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestiondestock.backend.backendgestiondestock.entity.Vente;
import com.gestiondestock.backend.backendgestiondestock.repo.VenteRepository;
import com.gestiondestock.backend.enumeration.ETAT_VENTE;

public class VenteServiceImp implements VenteService {
	
	@Autowired
	VenteRepository venteRepository;
	@Override
	public Vente saveVente(Vente v) {
		// TODO Auto-generated method stub
		return venteRepository.save(v);
	}

	@Override
	public Vente updateVente(Vente v) {
		// TODO Auto-generated method stub
		return saveVente(v);
	}

	@Override
	public void deleteVente(Vente v) {
		// TODO Auto-generated method stub
		v.setEtat_vente(ETAT_VENTE.ANNULATION.name());
		updateVente(v);
	}

	@Override
	public void deleteVenteById(Long id) {
		// TODO Auto-generated method stub
		Vente v =getVente(id);
		v.setEtat_vente(ETAT_VENTE.ANNULATION.name());
		updateVente(v);
	}

	@Override
	public Vente getVente(Long id) {
		// TODO Auto-generated method stub
		return venteRepository.findById(id).get();
	}

	@Override
	public List<Vente> getAllVente() {
		// TODO Auto-generated method stub
		return venteRepository.findAll();
	}

}
