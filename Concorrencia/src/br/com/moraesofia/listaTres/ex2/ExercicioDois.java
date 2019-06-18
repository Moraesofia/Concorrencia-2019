package br.com.moraesofia.listaTres.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExercicioDois {

    public static void main(String[] args) {
        int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int x = 10;
        int numThreads = 5;
        System.out.println("Retorno: " + parallelSearch(x, A, numThreads));

    }

    public static int parallelSearch(int x, int[] A, int numThreads) {
        if (A.length % numThreads != 0) {
            System.err.println("O array só pode ser dividido em partes iguais");
            System.exit(1);
        }

        List<ProcuraEmArray> threads = new ArrayList<>();
        int tamSubArrays = A.length / numThreads;
        int inicio = 0;
        int fim = tamSubArrays;

        for (int i = 0; i < numThreads; i++) {
            int b[] = new int[tamSubArrays];
            b = Arrays.copyOfRange(A, inicio, fim);
            inicio += tamSubArrays;
            fim += tamSubArrays;

            ProcuraEmArray t = new ProcuraEmArray(i + 1, b, x);
            threads.add(t);
            t.start();
        }

        for (ProcuraEmArray t : threads) {
            if (t.getRetorno() != -1) {
                System.out.println("Numero " + x + " encontrado pela " + t.getName());
                int posicao = t.getNum() * tamSubArrays - t.getRetorno();
                return posicao;
            }
        }
        return -1;
    }

}
