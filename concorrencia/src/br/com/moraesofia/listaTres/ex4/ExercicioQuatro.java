package br.com.moraesofia.listaTres.ex4;

public class ExercicioQuatro {

    public static void main(String[] args) {

        Mailbox mail = new Mailbox();

        Producer p1 = new Producer(mail, "Mensagem Um");
        Consumer c1 = new Consumer(mail);
        Producer p2 = new Producer(mail, "Mensagem dois");
        Consumer c2 = new Consumer(mail);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }

}
