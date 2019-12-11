package com.br.wd;

public class paralelo extends Sequencial implements Runnable{

    private Starter starter;
    private Sequencial sequencial = new Sequencial();

    public paralelo(Starter starter) {
        this.starter = starter;
    }

    @Override
    public void obterCentroide(Starter starter) {
        super.obterCentroide(starter);
    }

    @Override
    public Boolean atualizaCentroides(Starter starter) {
        return super.atualizaCentroides(starter);
    }

    @Override
    public void run() {

    }
}
