package com.gestiondestock.backend.backendgestiondestock.service;

import com.gestiondestock.backend.backendgestiondestock.dto.VenteArticleDTO;
import com.gestiondestock.backend.backendgestiondestock.entity.VenteArticle;
import com.gestiondestock.backend.backendgestiondestock.repo.VenteArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteArticleServiceImp implements VenteArticleService {

    @Autowired
    private VenteArticleRepository venteArticleRepository;


    @Override
    public VenteArticle saveVenteArticle(VenteArticle va) {
        return null;
    }

    @Override
    public VenteArticle updateVenteArticle(VenteArticle va) {
        return null;
    }

    @Override
    public void deleteVenteArticle(VenteArticle va) {

    }

    @Override
    public void deleteVenteArticleById(Long id) {

    }

    @Override
    public VenteArticle findVenteArticle(Long id) {
        return null;
    }

    @Override
    public List<VenteArticle> findAllVenteArticle() {
        return List.of();
    }

    @Override
    public VenteArticleDTO getArticleTotalAmountAndPrice() {
        Integer getAmount = venteArticleRepository.findArticleTotalAmount();
        Double getPrice = venteArticleRepository.findArticleTotalPrice();


        VenteArticleDTO venteArticleDTO = new VenteArticleDTO();

        if (getAmount != null || getPrice != null) {
            venteArticleDTO.setQuantite_vente_article(getAmount);
            venteArticleDTO.setTotal_vente_article(getPrice);
        } else {
            venteArticleDTO.setQuantite_vente_article(0);
            venteArticleDTO.setTotal_vente_article(0.0);
        }


        return venteArticleDTO;
    }

}
