package com.gestiondestock.backend.backendgestiondestock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table (name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_USER;
	
	@Column(name="Nom")
    private String Nom;
	
	@Column(name="Prenom")
    private String Prenom;
	
	@Column(name="Adresse")
    private String Adresse;
	
	@Column(name="Contact")
    private String Contact;
	
	@Column(name="role")
	private String role;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	@Column(name="etat")
	private String etat;
	@Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "BlockedDate")
	private Date BlockedDate;
	@Column(name = "UnblockedDate")
	private  Date UnblockedDate;
	@Column(name = "BlockedByAgent")
	private  String BlockedByAgent;
	@Column(name = "UnblockedByAgent")
	private  String UnblockedByAgent;
	@Column(name = "BlockedComment")
	private	String BlockedComment;
	@Column(name = "UnblockedComment")
	private  String UnblockedComment;
	
	public long getId_USER() {
		return id_USER;
	}
	public void setId_USER(long id_USER) {
		this.id_USER = id_USER;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String nom, String prenom, String adresse, String contact, String role, String login, String password,
			String etat) {
		super();
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		Contact = contact;
		this.role = role;
		this.login = login;
		this.password = password;
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "User [id_USER=" + id_USER + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse
				+ ", Contact=" + Contact + ", role=" + role + ", login=" + login + ", password=" + password + ", etat="
				+ etat + "]";
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getBlockedDate() {
		return BlockedDate;
	}

	public void setBlockedDate(Date blockedDate) {
		BlockedDate = blockedDate;
	}

	public Date getUnblockedDate() {
		return UnblockedDate;
	}

	public void setUnblockedDate(Date unblockedDate) {
		UnblockedDate = unblockedDate;
	}

	public String getBlockedByAgent() {
		return BlockedByAgent;
	}

	public void setBlockedByAgent(String blockedByAgent) {
		BlockedByAgent = blockedByAgent;
	}

	public String getUnblockedByAgent() {
		return UnblockedByAgent;
	}

	public void setUnblockedByAgent(String unblockedByAgent) {
		UnblockedByAgent = unblockedByAgent;
	}

	public String getBlockedComment() {
		return BlockedComment;
	}

	public void setBlockedComment(String blockedComment) {
		BlockedComment = blockedComment;
	}

	public String getUnblockedComment() {
		return UnblockedComment;
	}

	public void setUnblockedComment(String unblockedComment) {
		UnblockedComment = unblockedComment;
	}
}
