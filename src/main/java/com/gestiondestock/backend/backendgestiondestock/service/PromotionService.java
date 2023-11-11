package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import com.gestiondestock.backend.backendgestiondestock.entity.Promotion;

public interface PromotionService {
	
	Promotion savePromotion(Promotion promo);
	Promotion  updatePromotion(Promotion promo);
	void deletePromotion(Promotion promo);
	void deletePromotionById(Long id);
	Promotion  getPromotion (Long id);
	List<Promotion > getAllPromotion ();

}
