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

import com.br.wd.Paralelo.Paralelo;


public class Main {
    public static long tempoInicial;
    public static long tempoFinal;
    public static double tempoExecucao;
    public final static long TIMECONS = 1000000000;
    public static String pathPontos;
    public static String pathCentroides;


    private static Sequencial sequencial = new Sequencial();

    public static void main(String[] args) {
        Integer numThreads = null;
        try {
            numThreads = Integer.valueOf(args[0]);
            System.out.println(numThreads);
        } catch (RuntimeException e) {
            numThreads = 8;
            System.out.println("Número de threads não informado, executando com valor padrão (8)");
            System.out.println(" ");
        }
        System.err.println("Execução Paralela");

        executarParalelo(numThreads);

        System.err.println("Execução Sequencial");
        executarSequencial();


    }

    private static void executarSequencial() {
        Starter starter = new Starter();

        Boolean ctrl = true;
        starter.inicializaEntrada();
        int teste = 0;


        tempoInicial = System.nanoTime();
        while (ctrl) {
            sequencial.obterCentroide(starter, 0, starter.getPontos().size());
            ctrl = sequencial.atualizaCentroides(starter, 0, starter.getCentroides().size());
            teste++;
        }
        tempoFinal = System.nanoTime();
        tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Fim! tempo de execução: " + tempoExecucao / TIMECONS + " segundos");
        System.out.println("Foram feitas " + teste + " iterações");
    }

    private static void executarParalelo(int numThreads) {
        Starter starter = new Starter();

        starter.inicializaEntrada();
        Paralelo paralelo = new Paralelo(starter);
        paralelo.executarParalelo(numThreads);
    }


}