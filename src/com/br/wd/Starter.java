package com.br.wd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    private List<List<Integer>> pontosRaw = new ArrayList<>();
    private List<List<Integer>> CentroidesRaw = new ArrayList<>();

    private List<Centroide> centroides = new ArrayList<>();
    private List<Ponto> pontos = new ArrayList<>();

    public Boolean comparaAtr(List<Integer> old, List<Integer> nova) {
        Boolean toReturn = true;
        if (old.size() == nova.size()) {
            for (int i = 0; i < old.size(); i++) {
                if (old.get(i).intValue() != nova.get(i).intValue()) {
                    toReturn = false;
                    break;
                }
            }
        } else {
            toReturn = false;

        }
        return toReturn;
//        return old.equals(nova);
    }


    public void inicializaEntrada() {
        pontosRaw = readFile("/home/wd/int_base_59.csv");
        CentroidesRaw = readFile("/home/wd/int_centroid_59_20.csv");

        for (List atr : CentroidesRaw) {
            centroides.add(new Centroide(atr));
        }
        for (List atr : pontosRaw) {
            pontos.add(new Ponto(atr));
        }
        System.out.println("Aguarde, o algoritmo está em execução...");
    }


    private List<List<Integer>> readFile(String path) {
        List<List<Integer>> toReturn = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> auxInt = new ArrayList<>();
                String[] values = line.split(",");
                for (String value : values) {
                    auxInt.add(Integer.parseInt(value));
                }
                toReturn.add(auxInt);
            }
            return toReturn;

        } catch (IOException e) {
            System.out.println("Erro na Leitura do Arquivo!!!!");
            e.printStackTrace();
        }
        return null;
    }


    public List<Ponto> getPontos() {
        return pontos;
    }

    public List<Centroide> getCentroides() {
        return centroides;
    }


}
