package com.gestiondestock.backend.backendgestiondestock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vente_article")
public class VenteArticle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_vente_article;
	
	@Column(name="montant_vente_article")
	float montant_vente_article;
	
	@Column(name="quantite_vente_article")
	float quantite_vente_article;
	
	@Column(name="total_vente_article")
	float total_vente_article;
	
	@Column(name="etat_vente_article")
	String etat_vente_article;
	
	@Column(name="id_vente")
	int id_vente;
	
	@Column(name="id_article")
	int id_article;

	
	public VenteArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public VenteArticle(float montant_vente_article, float quantite_vente_article, float total_vente_article,
			String etat_vente_article) {
		super();
		this.montant_vente_article = montant_vente_article;
		this.quantite_vente_article = quantite_vente_article;
		this.total_vente_article = total_vente_article;
		this.etat_vente_article = etat_vente_article;
	}



	public int getId_vente_article() {
		return id_vente_article;
	}

	public void setId_vente_article(int id_vente_article) {
		this.id_vente_article = id_vente_article;
	}

	public float getMontant_vente_article() {
		return montant_vente_article;
	}

	public void setMontant_vente_article(float montant_vente_article) {
		this.montant_vente_article = montant_vente_article;
	}

	public float getQuantite_vente_article() {
		return quantite_vente_article;
	}

	public void setQuantite_vente_article(float quantite_vente_article) {
		this.quantite_vente_article = quantite_vente_article;
	}

	public float getTotal_vente_article() {
		return total_vente_article;
	}

	public void setTotal_vente_article(float total_vente_article) {
		this.total_vente_article = total_vente_article;
	}

	public String getEtat_vente_article() {
		return etat_vente_article;
	}

	public void setEtat_vente_article(String etat_vente_article) {
		this.etat_vente_article = etat_vente_article;
	}

	public int getId_vente() {
		return id_vente;
	}

	public void setId_vente(int id_vente) {
		this.id_vente = id_vente;
	}

	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	@Override
	public String toString() {
		return "VenteArticle [id_vente_article=" + id_vente_article + ", montant_vente_article=" + montant_vente_article
				+ ", quantite_vente_article=" + quantite_vente_article + ", total_vente_article=" + total_vente_article
				+ ", etat_vente_article=" + etat_vente_article + ", id_vente=" + id_vente + ", id_article=" + id_article
				+ "]";
	}
	
	
	
}
