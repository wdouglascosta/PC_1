package com.br.wd.Paralelo;

import com.br.wd.Starter;

import java.util.ArrayList;
import java.util.List;

import static com.br.wd.Functions.cont;

public class Main {

    public static long tempoInicial;
    public static long tempoFinal;
    public static double tempoExecucao;
    public final static long TIMECONS = 1000000000;


    private static Starter starter = new Starter();
    private static Paralelo paralelo = new Paralelo();

    public static void main(String[] args) {
        Boolean ctrl = true;
        starter.inicializaEntrada();

        int teste = 0;

        int i;
        tempoInicial = System.nanoTime();


        tempoFinal = System.nanoTime();
        tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("PARALELO");
        System.out.println("Fim! tempo de execução: " + tempoExecucao / TIMECONS + " segundos");
        System.out.println("Foram feitas " + teste + " iterações");
        System.out.println("contador: " + cont);
    }

    public static void iniciarThread(Thread thread) {
        System.out.println("nome da thread:--------------- " + thread.getName());
        System.out.println("id da thread: " + thread.getId());
        thread.start();
    }

    public static List<Thread> executarParalelo(int numThreads) {

//        List<Thread> threads = new ArrayList<>();
//
//        for (int i = 0; i < numThreads; i++) {
//            threads.add(new Thread(new ProcessoObterCentroide(), String.valueOf(i)));
//        }
//        return threads;
        return null;
    }

}
