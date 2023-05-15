package com.example.fartosandroid.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {

    private String nom;
    public List<CartaUltima> ma = new ArrayList<>();
    private boolean zancadilla = false;
    private int spriteResource;
    private int iconResource;
    private boolean patada = false;
    private int numCasella = -1;
    private boolean p;

    public Jugador() {
    }

    public Jugador(String nom, List<CartaUltima> ma, boolean patada, boolean zancadilla, int sprite) {
        this.nom = nom;
        this.ma = ma;
        this.patada = patada;
        this.zancadilla = zancadilla;
        this.spriteResource = sprite;
    }

    public Jugador(String nom, int sprite, int iconResource) {
        this.nom = nom;
        this.spriteResource = sprite;
        this.iconResource = iconResource;
    }

    public Jugador(String nom) {
        this.nom = nom;
    }



    public int getNumCasella() {
        return numCasella;
    }

    public void setNumCasella(int numCasella) {
        this.numCasella = numCasella;
    }

    public boolean isP() {
        return p;
    }

    public void setP(boolean p) {
        this.p = p;
    }

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<CartaUltima> getMa() {
        return ma;
    }

    public void setMa(List<CartaUltima> ma) {
        this.ma = ma;
    }

    public boolean isPatada() {
        return patada;
    }

    public void setPatada(boolean patada) {
        this.patada = patada;
    }

    public boolean isZancadilla() {
        return zancadilla;
    }

    public void setZancadilla(boolean zancadilla) {
        this.zancadilla = zancadilla;
    }

    public int getSprite() {
        return spriteResource;
    }

    public void setSprite(int sprite) {
        this.spriteResource = sprite;
    }

}
