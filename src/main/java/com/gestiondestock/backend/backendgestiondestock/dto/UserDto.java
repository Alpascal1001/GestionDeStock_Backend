package com.gestiondestock.backend.backendgestiondestock.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserDto implements Serializable {
    private Long idUser;
    private String loginBlockedAgent;
    private String loginUnblockedAgent;
    private String comentBlockedAgent;
    private String comentUnBlockedAgent;
    private Date unblockedDate;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String Contact;
    private String role;
    private String login;
    private String etat;
    private Date createdAt;
}
