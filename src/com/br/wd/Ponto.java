package com.br.wd;

import java.util.List;

public class Ponto {
    int id;
    private List<Integer> atributos;
    private Centroide centroide;
    private static int idCounter;

    public Ponto(List<Integer> atributos) {
        idCounter++;
        this.id = idCounter;
        this.atributos = atributos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Integer> atributos) {
        this.atributos = atributos;
    }

    public Centroide getCentroide() {
        return centroide;
    }

    public void setCentroide(Centroide centroide) {
        this.centroide = centroide;
    }
}
