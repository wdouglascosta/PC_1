package com.br.wd;

public class Functions {
    public static long cont = 0;

    public double calcularDistancia(Ponto atbPonto, Centroide atbCentroide) throws Exception {
        double somatorio = 0;

        for (int i = 0; i < atbPonto.getAtributos().size(); i++) {

            somatorio += calcularAux(atbPonto.getAtributos().get(i), atbCentroide.getAtributos().get(i));
            cont++;
        }
        return Math.sqrt(somatorio);
//        return somatorio;

    }

    private double calcularAux(Integer x, Integer y) {
        int z;
        z = x - y;
//        return  z * 2;
        return z * z;
    }

}

