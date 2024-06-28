package com.gestiondestock.backend.backendgestiondestock.controller;


import com.gestiondestock.backend.backendgestiondestock.dto.VenteArticleDTO;
import com.gestiondestock.backend.backendgestiondestock.service.VenteArticleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("admin")
public class VenteArticleController {

    @Autowired
    private VenteArticleService venteArticleService;


    @GetMapping("/totauxAmountPrice")
    public ResponseEntity<VenteArticleDTO> getTotauxAmountPrice() {

        try {
            VenteArticleDTO venteArticleAmountDTO = venteArticleService.getArticleTotalAmountAndPrice();
            venteArticleAmountDTO.setErrorCode(200);
            venteArticleAmountDTO.setErrorMessage("Success !");
            return ResponseEntity.ok(venteArticleAmountDTO);
        } catch (NoSuchElementException e) {
            VenteArticleDTO errorVenteArticleDTO = new VenteArticleDTO();
            errorVenteArticleDTO.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorVenteArticleDTO.setErrorMessage("Not Found !");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorVenteArticleDTO);

        } catch (Exception e) {
            VenteArticleDTO erroVenteArticleDTO = new VenteArticleDTO();
            erroVenteArticleDTO.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            erroVenteArticleDTO.setErrorMessage(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroVenteArticleDTO);
        }
    }
}
