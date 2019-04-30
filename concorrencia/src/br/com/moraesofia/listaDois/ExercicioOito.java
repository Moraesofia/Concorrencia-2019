package br.com.moraesofia.listaDois;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExercicioOito {

    public static void main(String[] args) {
        enviaNoticias();
        escreveHora();

    }

    public static void enviaNoticias() {
        new Thread() {

            @Override
            public void run() {

                try {
                    String linha;
                    BufferedReader br = new BufferedReader(new FileReader("noticias.txt"));
                    while ((linha = br.readLine()) != null) {
                        System.out.println(linha);
                        Thread.sleep(5000);
                    }
                    br.close();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public static void escreveHora() {
        new Thread() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        LocalDateTime now = LocalDateTime.now();
                        System.out.println(now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
                        Thread.sleep(10000);
                    }
                    System.exit(0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}
