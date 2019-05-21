package br.com.moraesofia.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket server = new Socket("192.168.40.247", 12345);

        Scanner ouvirServidor = new Scanner(server.getInputStream());

        String texto = ouvirServidor.nextLine();

        System.out.println(texto);
    }

}
