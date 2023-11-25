package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import com.gestiondestock.backend.backendgestiondestock.entity.Etatdecaisse;

public interface EtatdecaisseService {

	Etatdecaisse saveEtatdecaisse(Etatdecaisse ec );
	Etatdecaisse  updateEtatdecaisse(Etatdecaisse ec);
	void deleteEtatdecaisse(Etatdecaisse ec);
	void deleteEtatdecaisseById(Long id);
	Etatdecaisse  getEtatdecaisse (Long id);
	List<Etatdecaisse > getAllEtatdecaisse ();
}
