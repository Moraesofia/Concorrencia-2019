package br.com.moraesofia.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket servidor = new Socket("192.168.40.247", 19980);

        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a marca de um carro");
        String carro = ler.nextLine();

        PrintStream saidaServidor = new PrintStream(servidor.getOutputStream());
        Scanner ouvirServidor = new Scanner(servidor.getInputStream());

        saidaServidor.println(carro);
        String resposta = ouvirServidor.nextLine();

        System.out.println(resposta);

    }

    public static void client() throws IOException {
        
        Socket server = new Socket("192.168.40.247", 12345);

        Scanner ouvirServidor = new Scanner(server.getInputStream());

        String texto = ouvirServidor.nextLine();

        System.out.println(texto);
    }

}
