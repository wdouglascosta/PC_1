package com.br.wd;

import java.util.ArrayList;
import java.util.List;

public class Centroide {
    private int id;
    private List<Integer> atributos;
    private List<Ponto> pontos = new ArrayList<>();
    private static int idCounter;
    private Integer[] atr;

    public Centroide(List<Integer> atributos) {
        idCounter++;
        this.id = idCounter;
        this.atributos = atributos;
    }

    public void addPonto(Ponto ponto){
        pontos.add(ponto);
    }

    public List<Integer> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Integer> atributos) {
        this.atributos = atributos;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public int getId() {
        return id;
    }
}
