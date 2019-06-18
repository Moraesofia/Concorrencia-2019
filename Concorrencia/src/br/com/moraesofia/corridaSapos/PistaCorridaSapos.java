package br.com.moraesofia.corridaSapos;

import java.util.ArrayList;
import java.util.List;

public class PistaCorridaSapos {

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        List<Sapo> sapos = new ArrayList<>();

        int numSapos = 2;
        int distanciaCorrida = 200;

        for (int i = 0; i < numSapos; i++) {
            Sapo s = new Sapo(distanciaCorrida, "Sapo" + i);
            sapos.add(s);
        }

        for (Sapo sapo : sapos) {
            Thread t = new Thread(sapo);
            threads.add(t);
            t.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int maior = 0;
        for (int i = 0; i < sapos.size(); i++) {
            if (sapos.get(maior).getTempoGasto() > sapos.get(i).getTempoGasto()) {
                Sapo temp = sapos.get(i);
                maior = i;
                sapos.remove(i);
                sapos.add(0, temp);
            }

        }

        System.out.println("\n--------- Colocação:");
        for (Sapo sapo : sapos) {
            System.out.println(sapo.getNome() + " com " + sapo.getTempoGasto() + "ms");
        }

    }

}
