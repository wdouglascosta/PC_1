package com.br.wd;

public class Functions {

    public double calcularDistancia(Ponto atbPonto, Centroide atbCentroide) {
        double somatorio = 0;

        for (int i = 0; i < atbPonto.getAtributos().size(); i++) {

            somatorio += calcularAux(atbPonto.getAtributos().get(i), atbCentroide.getAtributos().get(i));
        }
        return Math.sqrt(somatorio);

    }

    private double calcularAux(Integer x, Integer y) {
        int z;
        z = x - y;
        return z * z;
    }

}

