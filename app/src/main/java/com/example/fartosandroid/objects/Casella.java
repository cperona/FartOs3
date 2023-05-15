package com.example.fartosandroid.objects;


import java.io.Serializable;

public class Casella implements Serializable {
    private String nom;
    private int numCasella;
    private int p1;
    private int p2;
    private int ronda = 1;


    public Casella(String nom, int numCasella, int p1, int p2) {
        this.numCasella = numCasella;
        this.p1 = p1;
        this.p2 = p2;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumCasella() {
        return numCasella;
    }

    public void setNumCasella(int numCasella) {
        this.numCasella = numCasella;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
}
