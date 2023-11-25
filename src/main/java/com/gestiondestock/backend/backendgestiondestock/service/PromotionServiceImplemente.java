package com.gestiondestock.backend.backendgestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestiondestock.backend.backendgestiondestock.entity.Promotion;
import com.gestiondestock.backend.backendgestiondestock.repo.PromotionRepository;

public class PromotionServiceImplemente implements PromotionService {
	
	@Autowired
	PromotionRepository promotionRepository;

	@Override
	public Promotion savePromotion(Promotion promo) {
		// TODO Auto-generated method stub
		return promotionRepository.save(promo);
	}

	@Override
	public Promotion updatePromotion(Promotion promo) {
		// TODO Auto-generated method stub
		return savePromotion(promo);
	}

	@Override
	public void deletePromotion(Promotion promo) {
		// TODO Auto-generated method stub
		promotionRepository.delete(promo);
	}

	@Override
	public void deletePromotionById(Long id) {
		// TODO Auto-generated method stub
		promotionRepository.deleteById(id);
	}

	@Override
	public Promotion getPromotion(Long id) {
		// TODO Auto-generated method stub
		return promotionRepository.findById(id).get();
	}

	@Override
	public List<Promotion> getAllPromotion() {
		// TODO Auto-generated method stub
		return promotionRepository.findAll();
	}

}
