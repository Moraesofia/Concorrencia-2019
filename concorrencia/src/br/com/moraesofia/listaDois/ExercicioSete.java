package br.com.moraesofia.listaDois;

import java.util.Scanner;

public class ExercicioSete {

    public static void main(String[] args) {

        long tiVal, tfVal;
        long tiCalc, tfCalc;

        @SuppressWarnings("resource")
        Scanner ler = new Scanner(System.in);
        int l = Integer.parseInt(ler.nextLine());
        int c = Integer.parseInt(ler.nextLine());

        int matriz[][] = new int[l][c];
        int somaLinhas[] = new int[l];
        int total = 0;

        // Gerando Valores
        tiVal = System.currentTimeMillis();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
        tfVal = System.currentTimeMillis();

        // Calculando Somatorio
        tiCalc = System.currentTimeMillis();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                total += matriz[i][j];
                somaLinhas[i] += matriz[i][j];
            }
        }
        tfCalc = System.currentTimeMillis();

        // Resultados
        System.out.println("Somatório total: " + total);
        for (int i = 0; i < somaLinhas.length; i++) {
            System.out.println("Somatório linha " + i + " = " + somaLinhas[i]);
        }
        System.out.println("Tempo gasto para gerar valores: " + (tfVal - tiVal) + " ms");
        System.out.println("Tempo gasto para calcular as somas: " + (tfCalc - tiCalc) + " ms");

    }

}
