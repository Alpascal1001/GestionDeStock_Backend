package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.Promotion;
import com.gestiondestock.backend.backendgestiondestock.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/promotions")
public class PromotionController {
    @Autowired
    private PromotionService promoService;


    @PostMapping("/addPromo")
    public Promotion addPromo(@RequestBody Promotion promo) {
        return promoService.savePromotion(promo);
    }

    @GetMapping("/listPromo")
    public List<Promotion> getAllPromo() {
        return promoService.getAllPromotion();
    }

    @PutMapping("/updatePromo")
    public Promotion updatePromo(@RequestBody Promotion promo) {
        return promoService.updatePromotion(promo);
    }

    @DeleteMapping("/deletePromo/{id}")
    public void deletePromo(@PathVariable Long id) {
        promoService.deletePromotionById(id);
    }
}
