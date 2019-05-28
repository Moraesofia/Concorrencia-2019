package br.com.moraesofia.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static ServerSocket chat;

    public static void main(String[] args) throws IOException {
        chat = new ServerSocket(19980);
        System.out.println("Iniciando");

        while (true) {
            System.out.println("Aguardando conexão...");
            Socket cliente = chat.accept();
            System.out.println("Cliente " + cliente.getInetAddress().getHostAddress() + " conectado...");
            Thread t = new AtenderCliente(cliente);
            t.start();
        }

    }

}
