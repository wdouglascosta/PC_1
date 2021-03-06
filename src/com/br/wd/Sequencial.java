package com.br.wd;

import java.util.ArrayList;
import java.util.List;

public class Sequencial {
    private Functions functions = new Functions();


    public void obterCentroide(Starter starter, int indexInicial, int indexFinal) {
        if (indexFinal > starter.getPontos().size()) {
            indexFinal = starter.getPontos().size();
        }
        Ponto ponto = null;
        int aux = Integer.MAX_VALUE;
        for (int i = indexInicial; i < indexFinal; i++) {
            double menorDistancia = Double.MAX_VALUE;
            double distanciaAtual = 0;
            for (int j = 0; j < starter.getCentroides().size(); j++) {
                try {
                    distanciaAtual = functions.calcularDistancia(starter.getPontos().get(i), starter.getCentroides().get(j));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (distanciaAtual < menorDistancia) {
                    aux = j;
                    menorDistancia = distanciaAtual;
                    ponto = starter.getPontos().get(i);
                }
            }
            starter.getCentroides().get(aux).addPonto(ponto);
        }
    }

    public Boolean atualizaCentroides(Starter starter, int indexInicial, int indexFinal) {
        Boolean toReturn = false;
        for (int i = indexInicial; i < starter.getCentroides().size(); i++) {
            List<Integer> novosAtr = new ArrayList<>();

            for (int j = 0; j < starter.getCentroides().get(i).getAtributos().size(); j++) {
                int soma = 0;
                int media = 0;

                for (Ponto ponto : starter.getCentroides().get(i).getPontos()) {
                    try {

                        soma += ponto.getAtributos().get(j);
                    }catch (Exception e){
                        System.out.println("Falhou!");
                    }
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
