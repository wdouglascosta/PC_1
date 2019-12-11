//package com.br.wd;
//
//public class Main {
//    public static long tempoInicial;
//    public static long tempoFinal;
//    public static double tempoExecucao;
//    public final static long TIMECONS = 1000000000;
//
//
//    public static void main(String[] args) {
//        Starter starter = new Starter();
//        Sequencial sequencial = new Sequencial();
//
//        tempoInicial = System.nanoTime();
//
//        Boolean ctrl = true;
//        starter.inicializaEntrada();
//        int teste = 0;
//        while (ctrl) {
////            System.out.println("iteração: " + teste);
//            sequencial.obterCentroide(starter);
//            ctrl = sequencial.atualizaCentroides(starter);
//            teste++;
//        }
//        tempoFinal = System.nanoTime();
//        tempoExecucao = tempoFinal - tempoInicial;
//        System.out.println("Fim! tempo de execução: "+tempoExecucao / TIMECONS +" segundos");
//        System.out.println("Foram feitas "+ teste + " iterações");
//
//
//    }
//
//
//}


package com.br.wd;

import java.util.concurrent.CyclicBarrier;

import static com.br.wd.Functions.cont;

public class Main {
    public static long tempoInicial;
    public static long tempoFinal;
    public static double tempoExecucao;
    public final static long TIMECONS = 1000000000;


    private static Starter starter = new Starter();
    private static Sequencial sequencial = new Sequencial();

    public static void main(String[] args) {


        Boolean ctrl = true;
        starter.inicializaEntrada();
        int teste = 0;


        tempoInicial = System.nanoTime();
        while (ctrl) {
            sequencial.obterCentroide(starter);
            ctrl = sequencial.atualizaCentroides(starter);
            teste++;
        }
        tempoFinal = System.nanoTime();
        tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Fim! tempo de execução: " + tempoExecucao / TIMECONS + " segundos");
        System.out.println("Foram feitas " + teste + " iterações");
        System.out.println("contador: " + cont);


    }

    public static void Paralelo(Starter starter) {
        Integer numThreads = 8;
        Thread threads[] = new Thread[numThreads];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numThreads);

        Boolean ctrl = true;
        Integer numPontos = starter.getPontos().size();
        Integer sobra = numPontos % numThreads;
        Integer partes = (numPontos - sobra) / numThreads;
        while (ctrl) {
            for (Thread thread : threads){
                for

            }
            sequencial.obterCentroide(starter);
            ctrl = sequencial.atualizaCentroides(starter);

        }
    }


}