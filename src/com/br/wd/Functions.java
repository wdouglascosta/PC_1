package com.br.wd;

import java.util.ArrayList;
import java.util.List;

public class Functions {







    private int valorX;
    private int valorY;


    private List<Integer> teste = new ArrayList<>();

    public double calcularDistancia(Ponto atbPonto, Centroide atbCentroide){
        double somatorio = 0;
        for (int i = 0; i < atbPonto.getAtributos().size(); i++) {
            somatorio =+ calcularAux(atbPonto.getAtributos().get(i), atbCentroide.getAtributos().get(i));
        }
        return Math.sqrt(somatorio);
    }

    private double calcularAux(Integer x, Integer y){
        int z;
        z = x-y;
        return Math.pow(z,2);
    }

}

