package br.com.moraesofia.prova1.questao7;

import java.util.Random;

/**
 *
 * 201602517-Sofia Martins Moraes
 *
 */
public class Tartaruga extends Thread {

    private int totalDistancia;

    private int distanciaPercorrida;

    private int qntPassos;

    private long time;

    private String nome;

    public Tartaruga(int totalDistancia, String nome) {
        this.totalDistancia = totalDistancia;
        this.nome = nome;
    }

    @Override
    public void run() {

        Random r = new Random();
        long tempoInicial = System.currentTimeMillis();
        distanciaPercorrida = 0;
        int dezPassos = 10;

        while (distanciaPercorrida < totalDistancia) {
            // passo tem de 0 a 5 cm
            distanciaPercorrida += r.nextInt(5);
            qntPassos++;
            try {
                // Espera de 0 a 3 ms
                Thread.sleep(r.nextInt(3));
            } catch (InterruptedException e) {
            }

            // De 10 em 10 passos, os cm percorridos são informados
            if (qntPassos == dezPassos) {
                System.out.println(nome + " antingiu " + dezPassos + " passos e andou " + distanciaPercorrida + " cm");
                dezPassos += 10;
            }
        }
        long tempoFinal = System.currentTimeMillis();
        time = tempoFinal - tempoInicial;
    }

    public int getTotalDistancia() {
        return totalDistancia;
    }

    public void setTotalDistancia(int totalDistancia) {
        this.totalDistancia = totalDistancia;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public int getQntPassos() {
        return qntPassos;
    }

    public void setQntPassos(int qntPassos) {
        this.qntPassos = qntPassos;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
