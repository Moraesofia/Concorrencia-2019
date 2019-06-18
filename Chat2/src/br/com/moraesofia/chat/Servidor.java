package br.com.moraesofia.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    private static ServerSocket chat;

    public static void main(String[] args) throws IOException {
        chat = new ServerSocket(19980);
        System.out.println("Iniciando");
        ExecutorService executor = Executors.newCachedThreadPool();

        while (true) {
            System.out.println("Aguardando conexão...");
            Socket cliente = chat.accept();
            System.out.println("Cliente " + cliente.getInetAddress().getHostAddress() + " conectado...");
            executor.execute(new AtenderCliente(cliente));
        }

    }

}
