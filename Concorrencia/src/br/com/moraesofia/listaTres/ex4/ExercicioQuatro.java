package br.com.moraesofia.listaTres.ex4;

public class ExercicioQuatro {

    public static void main(String[] args) {

        Mailbox mail = new Mailbox();

        Producer p1 = new Producer(mail, "Mensagem Um", "ProdutorUm");
        Consumer c1 = new Consumer(mail, "ConsumidorUm");
        Producer p2 = new Producer(mail, "Mensagem dois", "ProdutorDois");
        Consumer c2 = new Consumer(mail, "ConsumidorDois");

        p1.start();
        c1.start();
        c2.start();
        p2.start();
    }

}
