package br.com.moraesofia.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket server;
    private static Scanner ouvirServidor;

    public static void main(String[] args) throws IOException {

        server = new Socket("localhost", 12345);

        ouvirServidor = new Scanner(server.getInputStream());

        String texto = ouvirServidor.nextLine();

        System.out.println(texto);

    }

    // public static void client() throws IOException {
    //
    // servidor = new Socket("192.168.40.247", 19980);
    //
    // ler = new Scanner(System.in);
    // System.out.println("Digite a marca de um carro");
    // String carro = ler.nextLine();
    //
    // PrintStream saidaServidor = new PrintStream(servidor.getOutputStream());
    // ouvirServidor = new Scanner(servidor.getInputStream());
    //
    // saidaServidor.println(carro);
    // String resposta = ouvirServidor.nextLine();
    //
    // System.out.println(resposta);
    // }

}
