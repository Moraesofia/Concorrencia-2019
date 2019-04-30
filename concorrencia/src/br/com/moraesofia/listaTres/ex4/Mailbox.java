package br.com.moraesofia.listaTres.ex4;

public class Mailbox {

    private String message;

    synchronized void storeMessage(String m) {

        if (message != null) {
            return;
        }

        message = m;
        System.out.println("Escrevendo mensagem: " + message);
        notifyAll();

        while (message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized String retrieveMessage() {

        if (message == null) {
            return null;
        }

        System.out.println("Obtendo mensagem: " + message);
        message = null;
        notifyAll();

        while (message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return message;
    }

}
