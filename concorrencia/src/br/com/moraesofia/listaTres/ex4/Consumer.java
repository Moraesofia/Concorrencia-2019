package br.com.moraesofia.listaTres.ex4;

public class Consumer extends Thread {

    private Mailbox mail;

    private String msgConsumida;

    private boolean executando;

    private String nome;

    public Consumer(Mailbox mail, String nome) {
        this.mail = mail;
        this.setNome(nome);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(nome);

        for (int i = 0; i < 5; i++) {
            setMsgConsumida(mail.retrieveMessage());
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

    public String getMsgConsumida() {
        return msgConsumida;
    }

    public void setMsgConsumida(String msgConsumida) {
        this.msgConsumida = msgConsumida;
    }

}
