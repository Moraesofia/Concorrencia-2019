package br.com.moraesofia.prova1.questao8;

/**
 * 201602517-Sofia Martins Moraes
 *
 */
public class Main {

    public static void main(String[] args) {
        Deposito dep = new Deposito();

        Produtor p1 = new Produtor(dep, "Produtor1");
        Consumidor c1 = new Consumidor(dep, "Consumidor1");

        p1.start();
        c1.start();

        try {
            p1.join();
            c1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
