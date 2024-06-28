package com.gestiondestock.backend.backendgestiondestock.dto;

import lombok.Data;

@Data
public class VenteArticleDTO {

    private Integer errorCode;

    private String errorMessage;

    private Integer quantite_vente_article;

    private Double total_vente_article;

}
