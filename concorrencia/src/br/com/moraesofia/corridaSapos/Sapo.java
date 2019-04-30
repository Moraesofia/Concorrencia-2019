package br.com.moraesofia.corridaSapos;

import java.util.Random;

public class Sapo implements Runnable {

    private double distanciaPercorrida;

    private double distanciaDoPulo;

    @Override
    public void run() {
        Random r = new Random();
        setDistanciaDoPulo(r.nextInt(100) + 40); // cm pulados

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

}
