package br.com.moraesofia.listaTres.ex4;

public class Mailbox {

    private String message;

    synchronized void storeMessage(String m) {

        while (message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        message = m;
        System.out.println(Thread.currentThread().getName() + "*** escrevendo mensagem: " + message);
        notifyAll();

    }

    synchronized String retrieveMessage() {

        while (message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "*** obtendo mensagem: " + message);
        message = null;
        notifyAll();

        return message;
    }

}
