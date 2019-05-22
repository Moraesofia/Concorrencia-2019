package javaapplication1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

public class Cliente {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket servidor = new Socket("localhost", 19980);
        Scanner ler = new Scanner(System.in);
        System.err.println("Digite um nome de usuário");
        String username = ler.nextLine();

        System.out.println("Acessando chat");
        Thread.sleep(2000);
        while (true) {
            System.out.print(username + "> ");
            String texto = ler.nextLine();

            PrintStream saidaServidor = new PrintStream(servidor.getOutputStream());
            Scanner ouvirServidor = new Scanner(servidor.getInputStream());

            saidaServidor.println(texto);
            String resposta = ouvirServidor.nextLine();

            System.out.println(resposta);
        }

    }

    public static void teste() throws IOException {
        Socket servidor = new Socket("localhost", 19980);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite algo ");
        String carro = teclado.nextLine();

        PrintStream saidaServidor = new PrintStream(servidor.getOutputStream());
        Scanner ouvirServidor = new Scanner(servidor.getInputStream());

        saidaServidor.println(carro);
        String resposta = ouvirServidor.nextLine();

        System.out.println(resposta);
    }

}

