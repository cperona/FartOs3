package com.example.fartosandroid.objects;

import java.io.Serializable;

public class CartaUltima implements Serializable {
    private String nom;
    private  int tipus;
    private int skinResource;


    public CartaUltima(String nom, int skinResource) {
        this.nom = nom;
        this.skinResource = skinResource;
    }

    public CartaUltima(String nom, int skinResource, int tipus) {
        this.nom = nom;
        this.skinResource = skinResource;
        this.tipus = tipus;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSkinResource() {
        return skinResource;
    }

    public void setSkinResource(int skinResource) {
        this.skinResource = skinResource;
    }


    @Override
    public String toString() {
        return "CartaV{" +
                "nom='" + nom + '\'' +
                ", skin=" + skinResource +
                ", tipus=" + tipus +
                '}';
    }
}
