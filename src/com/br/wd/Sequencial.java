package com.br.wd;

import java.util.ArrayList;
import java.util.List;

public class Sequencial {
    private Functions functions = new Functions();


    public void obterCentroide(Starter starter) {
        Ponto ponto = null;
        int aux = Integer.MAX_VALUE;
        for (int i = 0; i < starter.getPontos().size(); i++) {
            double menorDistancia = Double.MAX_VALUE;
            double distanciaAtual = 0;
            for (int j = 0; j < starter.getCentroides().size(); j++) {
                try {
                    distanciaAtual = functions.calcularDistancia(starter.getPontos().get(i), starter.getCentroides().get(j));

                } catch (Exception e) {
                    e.printStackTrace();
                }


                if (distanciaAtual < menorDistancia) {
//                    System.out.println("distancia atual: " + distanciaAtual);
                    aux = j;
                    menorDistancia = distanciaAtual;
                    ponto = starter.getPontos().get(i);

                }
            }
            starter.getCentroides().get(aux).addPonto(ponto);
        }
    }

    public Boolean atualizaCentroides(Starter starter) {
        Boolean toReturn = false;
        for (int i = 0; i < starter.getCentroides().size(); i++) {
            List<Integer> novosAtr = new ArrayList<>();

            for (int j = 0; j < starter.getCentroides().get(i).getAtributos().size(); j++) {
                int soma = 0;
                int media = 0;
                int teste = 0;

                for (Ponto ponto : starter.getCentroides().get(i).getPontos()) {
                    soma += ponto.getAtributos().get(j).intValue();
                    teste++;
                }
                if (!starter.getCentroides().get(i).getPontos().isEmpty()) {

                    media = soma / starter.getCentroides().get(i).getPontos().size();
                    novosAtr.add(media);
                }

            }
            if (!novosAtr.isEmpty()) {

                if (!starter.comparaAtr(starter.getCentroides().get(i).getAtributos(), novosAtr)) {

                    starter.getCentroides().get(i).getAtributos().clear();

                    starter.getCentroides().get(i).setAtributos(novosAtr);
                    toReturn = true;
                }

            }

        }
        return toReturn;
    }
}
