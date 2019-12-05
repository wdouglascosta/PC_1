package com.br.wd;

public class Main {


    public static void main(String[] args) {
        Starter starter = new Starter();
        Sequencial sequencial = new Sequencial();

        starter.inicializaEntrada();
        sequencial.obterCentroide(starter);



    }


}