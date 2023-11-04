package com.gestiondestock.backend.backendgestiondestock.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name="etat_de_caisse")
public class Etatdecaisse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_etatcaisse;
	
	@Column(name="date_validation")
	Date date_validation;
	
	@Column(name="date_annulation")
	Date date_annulation;
	
	@Column(name="date_etatcaiise")
	Date date_etatcaiise;
	
	@Column(name="etat")
	String etat;
	
	@Column(name="id_USER")
	int id_USER;
	
	
	public Etatdecaisse() {
		super();
		// TODO Auto-generated constructor stub
		
		
	}
	public Etatdecaisse(Date date_validation, Date date_annulation, Date date_etatcaiise, String etat) {
		super();
		this.date_validation = date_validation;
		this.date_annulation = date_annulation;
		this.date_etatcaiise = date_etatcaiise;
		this.etat = etat;
	}
	public int getId_etatcaisse() {
		return id_etatcaisse;
	}
	public void setId_etatcaisse(int id_etatcaisse) {
		this.id_etatcaisse = id_etatcaisse;
	}
	public Date getDate_validation() {
		return date_validation;
	}
	public void setDate_validation(Date date_validation) {
		this.date_validation = date_validation;
	}
	public Date getDate_annulation() {
		return date_annulation;
	}
	public void setDate_annulation(Date date_annulation) {
		this.date_annulation = date_annulation;
	}
	public Date getDate_etatcaiise() {
		return date_etatcaiise;
	}
	public void setDate_etatcaiise(Date date_etatcaiise) {
		this.date_etatcaiise = date_etatcaiise;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getId_USER() {
		return id_USER;
	}
	public void setId_USER(int id_USER) {
		this.id_USER = id_USER;
	}
	@Override
	public String toString() {
		return "Etatdecaisse [id_etatcaisse=" + id_etatcaisse + ", date_validation=" + date_validation
				+ ", date_annulation=" + date_annulation + ", date_etatcaiise=" + date_etatcaiise + ", etat=" + etat
				+ ", id_USER=" + id_USER + "]";
	}

	
	
}
