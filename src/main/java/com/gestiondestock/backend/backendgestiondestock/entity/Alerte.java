package com.gestiondestock.backend.backendgestiondestock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "alerte")
public class Alerte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alert;

    @Column(name = "seuil_article")
    private float seuil_article;

    @Column(name = "nombre_vente_annule")
    private float nombre_vente_annule;

    @Column(name = "fin_promo")
    private Date fin_promo;

    @Getter
    @Setter
    @Column(name = "etat_alerte")
    private String etat_alert;

    @Column(name = "id_USER")
    private int id_USER;

    public Alerte() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Alerte(float seuil_article, float nombre_vente_annule, Date fin_promo) {
        super();
        this.seuil_article = seuil_article;
        this.nombre_vente_annule = nombre_vente_annule;
        this.fin_promo = fin_promo;
    }

    public int getId_alert() {
        return id_alert;
    }

    public void setId_alert(int id_alert) {
        this.id_alert = id_alert;
    }

    public float getSeuil_article() {
        return seuil_article;
    }

    public void setSeuil_article(float seuil_article) {
        this.seuil_article = seuil_article;
    }

    public float getNombre_vente_annule() {
        return nombre_vente_annule;
    }

    public void setNombre_vente_annule(float nombre_vente_annule) {
        this.nombre_vente_annule = nombre_vente_annule;
    }

    public Date getFin_promo() {
        return fin_promo;
    }

    public void setFin_promo(Date fin_promo) {
        this.fin_promo = fin_promo;
    }

    public int getId_USER() {
        return id_USER;
    }

    public void setId_USER(int id_USER) {
        this.id_USER = id_USER;
    }

    @Override
    public String toString() {
        return "Alerte [id_alert=" + id_alert + ", seuil_article=" + seuil_article + ", nombre_vente_annule="
                + nombre_vente_annule + ", fin_promo=" + fin_promo + ", id_USER=" + id_USER + "]";
    }


}
