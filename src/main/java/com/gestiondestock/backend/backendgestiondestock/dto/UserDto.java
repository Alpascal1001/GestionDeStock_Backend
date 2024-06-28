package com.gestiondestock.backend.backendgestiondestock.dto;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private String password;
    private String etat;
    private Date createdAt;

    //INORMATION FOR OUR AUTH
    private int statusCode;

    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private List<Article> articles;
    private User users;
}
