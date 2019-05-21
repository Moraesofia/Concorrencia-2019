package br.com.moraesofia.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(12345);
        Socket client = server.accept();

        String message = "A massage";

        PrintStream enviarDadosCliente = new PrintStream(client.getOutputStream());
        enviarDadosCliente.println(message);

    }

}
