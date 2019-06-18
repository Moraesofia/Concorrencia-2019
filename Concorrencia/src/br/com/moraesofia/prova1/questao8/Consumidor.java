package br.com.moraesofia.prova1.questao8;

/**
 *
 * 201602517-Sofia Martins Moraes
 *
 */
public class Consumidor extends Thread {

    private Deposito dep;

    private boolean condicao = true;

    public Consumidor(Deposito dep, String nome) {
        this.dep = dep;
        Thread.currentThread().setName(nome);
    }

    @Override
    public void run() {
        while (condicao) {
            dep.retirar();
        }
    }

}
