package com.br.wd;

import java.util.ArrayList;
import java.util.List;

public class Sequencial {
    private Starter starter = new Starter();
    private List<Centroide> centroides = starter.getCentroides();
    private List<Ponto> pontos = starter.getPontos();
    private Functions functions = new Functions();


    public void calcDistancia(){
        double menorDistancia = Double.MAX_VALUE;
        int idCloseCentroide = Integer.MAX_VALUE;
        for (int i = 0; i < pontos.size() ; i++) {
            for (Centroide centroide : centroides){
                if (functions.calcularDistancia(pontos.get(i),centroide) < menorDistancia){
                    idCloseCentroide = centroide.getId();
                }
            }
            pontos.get(i).setCentroide(centroides.get());
        }
    }

    public void calculaCentroide(){
        for (Ponto ponto : pontos){

        }
    }


}
