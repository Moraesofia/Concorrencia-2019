package br.com.moraesofia.listaTres.ex3;

import java.util.ArrayList;
import java.util.List;

public class ExercicioTres {

    public static void main(String[] args) {

        List<Lebre> lebres = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Lebre l = new Lebre("Lebre" + i);
            lebres.add(l);
            l.start();
        }

        for (Lebre lebre : lebres) {
            try {
                lebre.join();
            } catch (Exception e) {
            }
        }

        int maior = 0;
        for (int i = 0; i < lebres.size(); i++) {
            if (lebres.get(maior).getDistancia() < lebres.get(i).getDistancia()) {
                Lebre bb = lebres.get(i);
                maior = i;
                lebres.remove(i);
                lebres.add(0, bb);
            }

        }
        System.out.println();
        System.out.println("Ordem das vencedoras: ");
        for (Lebre lebre : lebres) {
            System.out.println(lebre.getNome() + " percorreu " + lebre.getDistancia() + " metros e deu "
                    + lebre.getPulos() + " pulos");
        }

    }

}
