package br.com.moraesofia.listaTres.ex4;

public class Consumer extends Thread {

    Mailbox mail;

    String msgConsumida;

    boolean executando;

    public Consumer(Mailbox mail) {
        this.mail = mail;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            msgConsumida = mail.retrieveMessage();
        }

    }

    public boolean isExecutando() {
        return executando;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

}
