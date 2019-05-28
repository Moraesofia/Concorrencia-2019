package br.com.moraesofia.prova1.questao8;

/**
 *
 * 201602517-Sofia Martins Moraes
 *
 */
public class Produtor extends Thread {

    private Deposito dep;

    private boolean condicao = true;

    public Produtor(Deposito dep, String nome) {
        this.dep = dep;
        Thread.currentThread().setName(nome);
    }

    @Override
    public void run() {
        while (condicao) {
            dep.colocar();
        }
    }

}
