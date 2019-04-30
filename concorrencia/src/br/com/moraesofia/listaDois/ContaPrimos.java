package br.com.moraesofia.listaDois;

public class ContaPrimos implements Runnable {

    public ContaPrimos() {
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }

    }

}
