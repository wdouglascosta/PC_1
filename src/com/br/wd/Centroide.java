package com.br.wd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Centroide {
    private int id;
    private List<Integer> atributos;
//    private ArrayList<Ponto> pontos = new ArrayList<>();
    private static int idCounter;
    private List pontos =Collections.synchronizedList(new ArrayList<Ponto>());

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
