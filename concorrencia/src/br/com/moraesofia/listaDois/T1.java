package br.com.moraesofia.listaDois;

public class T1 extends Thread {

    private int id;

    public T1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread " + id + " executando");
        }

    }

}
