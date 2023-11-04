package com.gestiondestock.backend.backendgestiondestock.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id_promo;
	
	@Column(name="date_debut")
	Date date_debut;
	
	@Column(name="date_fin")
	Date date_fin;
	
	@Column(name="taux_remise")
	float taux_remise;
	
	@Column(name="etat_promo")
	String etat_promo;
	
	@Column(name="id_USER")
	int id_USER;

	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promotion(Date date_debut, Date date_fin, float taux_remise, String etat_promo) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.taux_remise = taux_remise;
		this.etat_promo = etat_promo;
	}

	public int getId_promo() {
		return id_promo;
	}

	public void setId_promo(int id_promo) {
		this.id_promo = id_promo;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public float getTaux_remise() {
		return taux_remise;
	}

	public void setTaux_remise(float taux_remise) {
		this.taux_remise = taux_remise;
	}

	public String getEtat_promo() {
		return etat_promo;
	}

	public void setEtat_promo(String etat_promo) {
		this.etat_promo = etat_promo;
	}

	public int getId_USER() {
		return id_USER;
	}

	public void setId_USER(int id_USER) {
		this.id_USER = id_USER;
	}

	@Override
	public String toString() {
		return "Promotion [id_promo=" + id_promo + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", taux_remise=" + taux_remise + ", etat_promo=" + etat_promo + ", id_USER=" + id_USER + "]";
	}
	
	
	
}
