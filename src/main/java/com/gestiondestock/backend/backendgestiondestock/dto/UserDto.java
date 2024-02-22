package com.gestiondestock.backend.backendgestiondestock.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


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
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getLoginBlockedAgent() {
		return loginBlockedAgent;
	}
	public void setLoginBlockedAgent(String loginBlockedAgent) {
		this.loginBlockedAgent = loginBlockedAgent;
	}
	public String getLoginUnblockedAgent() {
		return loginUnblockedAgent;
	}
	public void setLoginUnblockedAgent(String loginUnblockedAgent) {
		this.loginUnblockedAgent = loginUnblockedAgent;
	}
	public String getComentBlockedAgent() {
		return comentBlockedAgent;
	}
	public void setComentBlockedAgent(String comentBlockedAgent) {
		this.comentBlockedAgent = comentBlockedAgent;
	}
	public String getComentUnBlockedAgent() {
		return comentUnBlockedAgent;
	}
	public void setComentUnBlockedAgent(String comentUnBlockedAgent) {
		this.comentUnBlockedAgent = comentUnBlockedAgent;
	}
	public Date getUnblockedDate() {
		return unblockedDate;
	}
	public void setUnblockedDate(Date unblockedDate) {
		this.unblockedDate = unblockedDate;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
    
	
}
