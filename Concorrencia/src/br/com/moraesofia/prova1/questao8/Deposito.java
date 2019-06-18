package br.com.moraesofia.prova1.questao8;

/**
 *
 * 201602517-Sofia Martins Moraes
 *
 */
public class Deposito {

    private int itens = 0;
    private final int capacidade = 10;

    public synchronized int retirar() {

        while (itens == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if (itens > 0) {
            itens--;
            System.out.println("Caixa retirada: sobram " + itens + " caixas");
            notifyAll();
            return 1;
        }

        return 0;
    }

    public synchronized int colocar() {

        while (itens >= capacidade) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if (itens < capacidade) {
            itens++;
            System.out.println("Caixa armazenada: passaram a ser " + itens + " caixas");
            notifyAll();
            return 1;
        }

        return 0;

    }

}
