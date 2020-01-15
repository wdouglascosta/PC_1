package com.br.wd.Paralelo;

import com.br.wd.Starter;

import java.util.concurrent.CyclicBarrier;

public class Paralelo {
    public static long tempoInicial;
    public static long tempoFinal;
    public static double tempoExecucao;
    public final static long TIMECONS = 1000000000;


//    private int numThreads = 8;
//    CyclicBarrier barreiraThread = new CyclicBarrier(numThreads);

    private Starter starter;
    public Paralelo(Starter starter) {
        this.starter = starter;
    }


    public void executarParalelo(int numThreads){
        Thread threads[] = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Processo(starter, numThreads, i));
            threads[i].setName(String.valueOf(i));
        }
        tempoInicial = System.nanoTime();
        for (Thread thread : threads){
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        tempoFinal = System.nanoTime();
        tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Fim! tempo de execução: " + tempoExecucao / TIMECONS + " segundos");


    }


}
