package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import com.gestiondestock.backend.backendgestiondestock.entity.Vente;


public interface VenteService {
	
	Vente saveVente(Vente v);
	Vente  updateVente(Vente v);
	void deleteVente(Vente v);
	void deleteVenteById(Long id);
	Vente  getVente (Long id);
	List<Vente > getAllVente ();
	

}
