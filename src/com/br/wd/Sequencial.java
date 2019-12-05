package com.br.wd;

import java.util.ArrayList;
import java.util.List;

public class Sequencial {
    private Starter starter = new Starter();
    private Functions functions = new Functions();


    public void obterCentroide(Starter starter) {
        double menorDistancia = Double.MAX_VALUE;
        double distanciaAtual = 0;
        for (int i = 0; i < starter.getPontos().size(); i++) {
            for (Centroide centroide : starter.getCentroides()) {
                distanciaAtual = functions.calcularDistancia(starter.getPontos().get(i), centroide);
                System.out.println("distancia atual: "+distanciaAtual);
                if (distanciaAtual < menorDistancia) {
                    menorDistancia = distanciaAtual;
                    Ponto ponto = starter.getPontos().get(i);
                    centroide.addPonto(ponto);

                }
            }
        }
        System.out.println("para aqui");
    }




}
