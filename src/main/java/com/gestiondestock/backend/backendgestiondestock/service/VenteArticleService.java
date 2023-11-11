package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;

public interface VenteArticleService {

	
	
	VenteArticle saveVenteArticle(VenteArticle va);
	VenteArticle  updateVenteArticle(VenteArticle va);
	void deleteVenteArticle(VenteArticle va);
	void deleteVenteArticleById(Long id);
	VenteArticle  findVenteArticle (Long id);
	List<VenteArticle > findAllVenteArticle ();
}
