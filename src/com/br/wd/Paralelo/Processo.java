package com.br.wd.Paralelo;

import com.br.wd.Functions;
import com.br.wd.Ponto;
import com.br.wd.Starter;

import java.util.ArrayList;
import java.util.List;

public class Processo implements Runnable {
    private Starter starter;
    private int qtdThreads;


    private Functions functions = new Functions();
    String teste = Thread.currentThread().getName();
    int threadId;

    public Processo(Starter starter, int qtdThreads, int threadId) {
        this.qtdThreads = qtdThreads;
        this.starter = starter;
        this.threadId = threadId;
    }


    public void obterCentroide() {

        Ponto ponto = null;
        int aux = Integer.MAX_VALUE;
        for (int i = threadId; i < starter.getPontos().size(); i += qtdThreads) {
            double menorDistancia = Double.MAX_VALUE;
            double distanciaAtual = 0;
            for (int j = 0; j < starter.getCentroides().size(); j++) {
                try {
                    distanciaAtual = functions.calcularDistancia(starter.getPontos().get(i), starter.getCentroides().get(j));

                } catch (Exception e) {
                    System.out.println("falha na chamada da função Calcular Distancia");
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

    public Boolean atualizaCentroides() {
        Boolean toReturn = false;

        for (int i = threadId; i < starter.getCentroides().size(); i += qtdThreads) {
            List<Integer> novosAtr = new ArrayList<>();

            for (int j = 0; j < starter.getCentroides().get(i).getAtributos().size(); j++) {
                int soma = 0;
                int media = 0;

                for (Ponto ponto : starter.getCentroides().get(i).getPontos()) {
                    try {

                        soma += ponto.getAtributos().get(j);
                    } catch (Exception e) {
                        e.printStackTrace();
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


    @Override
    public void run() {
        boolean ctrl = true;
        int contador = 0;
        while (ctrl) {

            obterCentroide();


            ctrl = atualizaCentroides();
            contador++;
        }
        System.out.println("Thread num: "+ Thread.currentThread().getName() + " executou " + contador +" iterações");
    }
}
