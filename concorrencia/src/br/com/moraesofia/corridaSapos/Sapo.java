package br.com.moraesofia.corridaSapos;

import java.util.Random;

public class Sapo implements Runnable {

    private double distanciaPercorrida;

    private long tempoGasto;

    private double distanciaDoPulo;

    private int distanciaTotal;

    private String nome;

    private boolean metade;

    public Sapo(int distanciaTotal, String nome) {
        this.nome = nome;
        this.distanciaTotal = distanciaTotal;
    }

    @Override
    public void run() {
        Random r = new Random();
        metade = false;
        long tempoInicial = System.currentTimeMillis();
        System.out.println(nome + " iniciou a corrida!");

        while (distanciaPercorrida < distanciaTotal) {
            setDistanciaDoPulo(r.nextInt(100) + 40);

            try {
                Thread.sleep(r.nextInt(1000) + 2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.distanciaPercorrida += getDistanciaDoPulo();

            if (distanciaPercorrida >= (distanciaTotal / 2) && !metade) {
                System.out.println("Sapo " + this.nome + " chegou na metade da corrida");
                metade = true;

                try {
                    Thread.sleep(r.nextInt(1000) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Sapo " + this.nome + " terminou a corrida");
        long tempoFinal = System.currentTimeMillis();
        setTempoGasto(tempoFinal - tempoInicial);
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public double getDistanciaDoPulo() {
        return distanciaDoPulo;
    }

    public void setDistanciaDoPulo(double distanciaDoPulo) {
        this.distanciaDoPulo = distanciaDoPulo;
    }

    public long getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(long tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
