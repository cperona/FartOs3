package com.example.fartosandroid.objects;

import java.util.*;

public class Carta {

    public enum TipusCarta {
        MOV_1(28), MOV_2(18), MOV_3(10),
        TELEPORT(3), ZANCADILLA(4), PATADA(3),
        HUNDIMIENTO(2), BROMA(2);

        private int numCartes;
        public int getNumCartes() { return numCartes; }

        TipusCarta(int numCartes) {
            this.numCartes = numCartes;
        }
    }


    private int numero;
    private TipusCarta efecte;


    public int getNumero() {
        return numero;
    }
    public TipusCarta getEfecte() {
        return efecte;
    }


    private Carta(int numero, TipusCarta efecte) {
        this.numero = numero;
        this.efecte = efecte;
    }




    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append(numero + " : ");
        switch (efecte) {
            case MOV_1:
                stringBuilder.append("Mov_1");
                break;

            case MOV_2:
                stringBuilder.append("Mov_2");
                break;

            case MOV_3:
                stringBuilder.append("Mov_3");
                break;

            default:
                stringBuilder.append(efecte.name() + "");
        }

        return stringBuilder.toString();
    }


    public static List<Carta> generarBaralla() {
        List<Carta> result = new ArrayList<>();
        int numeroCarta = 1;

        // Crea las cartes
        for (TipusCarta tipuscarta : TipusCarta.values()) {
            for (int i = 0; i < tipuscarta.getNumCartes(); i++)
                result.add(new Carta(numeroCarta++, tipuscarta));
        }

        // Reordena las cartes
        Collections.shuffle(result);

        return result;
    }
}
