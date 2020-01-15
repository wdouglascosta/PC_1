package com.br.wd.Paralelo;

import com.br.wd.*;

import java.util.ArrayList;
import java.util.List;

public class Processo implements Runnable{
    private List<Centroide> centroides;
    private List<Ponto> pontos;
    int qtdThreads;

    private Sequencial sequencial= new Sequencial();
    private Paralelo paralelo = new Paralelo();



    private Functions functions = new Functions();
    int threadId = Integer.parseInt(Thread.currentThread().getName());

    public Processo(int qtdThreads) {
        this.qtdThreads = qtdThreads;
    }


    public void obterCentroide(Starter starter, int indexInicial) {

        Ponto ponto = null;
        int aux = Integer.MAX_VALUE;
        for (int i = threadId; i < starter.getPontos().size(); i += qtdThreads) {
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

    public Boolean atualizaCentroides(Starter starter, int indexInicial) {
        Boolean toReturn = false;
        for (int i = threadId; i < starter.getCentroides().size(); i += qtdThreads) {

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

    @Override
    public void run() {
        sequencial.atualizaCentroides(starter);
//        System.out.println("ooooiii");
        boolean ctrl = true;

        while (ctrl) {
            obterCentroide(starter, 0, starter.getPontos().size());
            ctrl = atualizaCentroides(starter, 0, starter.getCentroides().size());
        }
    }
}
