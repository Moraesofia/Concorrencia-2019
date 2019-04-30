package br.com.moraesofia.listaTres.ex4;

public class Producer extends Thread {

    Mailbox mail;

    String msgProduzida;

    boolean executando;

    public Producer(Mailbox mail, String msg) {
        this.mail = mail;
        this.msgProduzida = msg;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            mail.storeMessage(msgProduzida);
        }

    }

    public boolean isExecutando() {
        return executando;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

}
