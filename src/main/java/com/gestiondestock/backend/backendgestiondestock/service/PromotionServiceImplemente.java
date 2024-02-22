package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.entity.Promotion;
import com.gestiondestock.backend.backendgestiondestock.repo.PromotionRepository;
import com.gestiondestock.backend.enumeration.ETAT_PROMO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionServiceImplemente implements PromotionService {

    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public Promotion savePromotion(Promotion promo) {
        // TODO Auto-generated method stub
        promo.setDate_debut(new Date());
        promo.setEtat_promo(ETAT_PROMO.ACTIF.toString());
        return promotionRepository.save(promo);
    }

    @Override
    public Promotion updatePromotion(Promotion promo) {
        // TODO Auto-generated method stub
        return promotionRepository.save(promo);
    }

    @Override
    public void deletePromotion(Promotion promo) {
        // TODO Auto-generated method stub
        promotionRepository.delete(promo);
    }

    @Override
    public void deletePromotionById(Long id) {
        // TODO Auto-generated method stub
        Promotion promo = getPromotion(id);
        promo.setEtat_promo(ETAT_PROMO.SUPPRIME.toString());
        updatePromotion(promo);
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
