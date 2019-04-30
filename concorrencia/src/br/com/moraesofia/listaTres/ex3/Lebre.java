package br.com.moraesofia.listaTres.ex3;

import java.util.Random;

public class Lebre extends Thread {

    private String nome;
    private int distancia;
    private int pulos;

    public Lebre(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {

        while (distancia < 20) {
            Random r = new Random();
            int i = r.nextInt(3);
            distancia += i;
            pulos++;

            System.out.println(nome + " saltou " + i + " metros");
        }

        Thread.currentThread();
        Thread.yield();
    }

    public int getPulos() {
        return pulos;
    }

    public int getDistancia() {
        return distancia;
    }

    public String getNome() {
        return nome;
    }

}
