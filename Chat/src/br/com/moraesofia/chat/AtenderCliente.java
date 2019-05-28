/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moraesofia.chat;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class AtenderCliente extends Thread {

    private Socket cliente;

    private String nome;

    private static List<PrintStream> saidas = new ArrayList<>();

    public AtenderCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        try {

            Scanner ouvirCliente = new Scanner(cliente.getInputStream());
            PrintStream saidaCliente = new PrintStream(cliente.getOutputStream());

            String mensagem = null;
            saidaCliente.println("Digite seu nome: ");
            this.nome = mensagem = ouvirCliente.nextLine();
            saidaCliente.println("Bem vindo " + nome + "!");
            saidas.add(saidaCliente);
            mensagem = nome + " entrou no chat";
            send(saidaCliente, mensagem);

            while (true) {
                mensagem = null;
                mensagem = ouvirCliente.nextLine();

                // TODO exception quando um cliente sai
                if ("sair".equalsIgnoreCase(mensagem)) {
                    send(saidaCliente, nome + "deixou o chat");
                    saidas.remove(saidaCliente);
                    ouvirCliente.close();
                } else {
                    send(saidaCliente, nome + " -> " + mensagem);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(PrintStream saidaCliente, String mensagem) {

        for (PrintStream s : saidas) {
            if (!(s == saidaCliente)) {
                s.println(mensagem);
            }
        }
    }

}
