package com.br.wd.Paralelo;

import com.br.wd.Functions;
import com.br.wd.Sequencial;
import com.br.wd.Starter;

public class Paralelo {

    private Functions functions = new Functions();


    private int indexInicial;
    private int indexFinal;

    private Starter starter;

    public Paralelo(Starter starter, int indexInicial, int indexFinal) {
        this.indexInicial = indexInicial;
        this.indexFinal = indexFinal;
        this.starter = starter;
    }

    public Paralelo() {
    }


}
