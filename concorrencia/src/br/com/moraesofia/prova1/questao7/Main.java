package br.com.moraesofia.prova1.questao7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 201602517-Sofia Martins Moraes
 *
 */
public class Main {

    static int distanciaCorrida = 200; // 2 metros = 200 centimetros
    static int qntTartarugas = 7;

    public static void main(String[] args) {

        List<Tartaruga> threads = new ArrayList<>();

        for (int i = 0; i < qntTartarugas; i++) {
            Tartaruga t = new Tartaruga(distanciaCorrida, "Tartaruga" + (i + 1));
            threads.add(t);
            t.start();
        }

        for (Tartaruga tartaruga : threads) {
            try {
                tartaruga.join();
            } catch (InterruptedException e) {
            }
        }

        ordenaLista(threads);

        System.out.println("Sequencia de chegada:");
        int index = 1;
        for (Tartaruga tar : threads) {
            System.out.println(index + " - " + tar.getNome() + " com " + tar.getQntPassos() + " passos e em "
                    + tar.getTime() + "ms");
            index++;
        }

    }

    public static void ordenaLista(List<Tartaruga> threads) {
        int melhor = 0;
        for (int i = 0; i < threads.size(); i++) {
            if (threads.get(melhor).getTime() > threads.get(i).getTime()) {
                Tartaruga temp = threads.get(i);
                threads.remove(i);
                threads.add(0, temp);
            }
        }
    }

}
