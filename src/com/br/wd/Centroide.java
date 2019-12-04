package com.br.wd;

import java.util.List;

public class Centroide {
    private int id;
    private List<Integer> atributos;
    private List<Ponto> pontos;
    private static int idCounter;

    public Centroide(List<Integer> atributos) {
        idCounter++;
        this.id = idCounter;
        this.atributos = atributos;
    }

    public List<Integer> getAtributos() {
        return atributos;
    }

    public int getId() {
        return id;
    }
}
