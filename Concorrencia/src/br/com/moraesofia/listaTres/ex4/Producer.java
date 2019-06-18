package br.com.moraesofia.listaTres.ex4;

public class Producer extends Thread {

    private Mailbox mail;

    private String msgProduzida;

    private boolean executando;

    private String nome;

    public Producer(Mailbox mail, String msg, String nome) {
        this.mail = mail;
        this.msgProduzida = msg;
        this.setNome(nome);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(nome);

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
