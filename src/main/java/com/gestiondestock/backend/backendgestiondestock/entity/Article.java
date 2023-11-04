package com.gestiondestock.backend.backendgestiondestock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_article;
	
	@Column(name="Nom")
	String nom;
	
	@Column(name="prix")
	String prix;
	
	@Column(name="qte_dispo")
	int qte_dispo;
	
	@Column(name="etat_article")
	String etat_article;
	
	@Column(name="id_USER")
	int id_USER;
	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
		
		
	}
	public Article(String nom, String prix, int qte_dispo, String etat_article) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.qte_dispo = qte_dispo;
		this.etat_article = etat_article;
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public int getQte_dispo() {
		return qte_dispo;
	}
	public void setQte_dispo(int qte_dispo) {
		this.qte_dispo = qte_dispo;
	}
	public String getEtat_article() {
		return etat_article;
	}
	public void setEtat_article(String etat_article) {
		this.etat_article = etat_article;
	}
	public int getId_USER() {
		return id_USER;
	}
	public void setId_USER(int id_USER) {
		this.id_USER = id_USER;
	}
	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", nom=" + nom + ", prix=" + prix + ", qte_dispo=" + qte_dispo
				+ ", etat_article=" + etat_article + ", id_USER=" + id_USER + "]";
	}

	
	
}

