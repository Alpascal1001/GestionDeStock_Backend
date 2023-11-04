package com.gestiondestock.backend.backendgestiondestock.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vente")
public class Vente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_vente; 
	
	@Column(name="date_annulation")
	Date date_annulation; //DateTime?
	
	@Column(name="date_vente")
	Date date_vente;
	
	@Column(name="etat_vente")
	String etat_vente;
	
	@Column(name="id_USER")
	int id_USER;

	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vente(Date date_annulation, Date date_vente, String etat_vente) {
		super();
		this.date_annulation = date_annulation;
		this.date_vente = date_vente;
		this.etat_vente = etat_vente;
	}

	public int getId_vente() {
		return id_vente;
	}

	public void setId_vente(int id_vente) {
		this.id_vente = id_vente;
	}

	public Date getDate_annulation() {
		return date_annulation;
	}

	public void setDate_annulation(Date date_annulation) {
		this.date_annulation = date_annulation;
	}

	public Date getDate_vente() {
		return date_vente;
	}

	public void setDate_vente(Date date_vente) {
		this.date_vente = date_vente;
	}

	public String getEtat_vente() {
		return etat_vente;
	}

	public void setEtat_vente(String etat_vente) {
		this.etat_vente = etat_vente;
	}

	public int getId_USER() {
		return id_USER;
	}

	public void setId_USER(int id_USER) {
		this.id_USER = id_USER;
	}

	@Override
	public String toString() {
		return "Vente [id_vente=" + id_vente + ", date_annulation=" + date_annulation + ", date_vente=" + date_vente
				+ ", etat_vente=" + etat_vente + ", id_USER=" + id_USER + "]";
	}
	
	
	

}
