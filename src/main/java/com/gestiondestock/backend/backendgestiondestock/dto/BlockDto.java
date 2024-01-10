package com.gestiondestock.backend.backendgestiondestock.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlockDto implements Serializable {
    private Long idUser;
    private String loginAgent;
    private String comment;
}
