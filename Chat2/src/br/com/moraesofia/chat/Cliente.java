package br.com.moraesofia.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private static Socket servidor;
    private static Scanner ler;
    private static Scanner ouvirServidor;

    public static void main(String[] args) throws IOException, InterruptedException {

        servidor = new Socket("localhost", 19980);
        ler = new Scanner(System.in);
        ThreadGroup group = new ThreadGroup("client");

        envia(group, "envia");
        recebe(group, "recebe");

    }

    public static void envia(ThreadGroup group, String nome) {
        new Thread(group, nome) {

            @Override
            public void run() {
                while (true) {

                    try {
                        String texto = ler.nextLine();
                        PrintStream saidaServidor;
                        saidaServidor = new PrintStream(servidor.getOutputStream());
                        saidaServidor.println(texto);
                        if (texto.equalsIgnoreCase("command:sair")) {
                            System.err.println("Você deixou o chat");
                            group.stop();
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        System.err.println("Não foi possível conectar-se");
                    }

                }
            }
        }.start();

    }

    public static void recebe(ThreadGroup group, String nome) {
        new Thread(group, nome) {

            @Override
            public void run() {
                while (true) {
                    try {
                        ouvirServidor = new Scanner(servidor.getInputStream());
                        String resposta = ouvirServidor.nextLine();
                        System.out.println(resposta);
                    } catch (IOException e) {
                        System.err.println("Não foi possível conectar-se");
                    }

                }
            }
        }.start();

    }

}
