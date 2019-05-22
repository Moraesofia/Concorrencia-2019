/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class AtenderCliente extends Thread {
    //private Socket cliente;

    private Socket cliente;

    public AtenderCliente(Socket cliente) {
        this.cliente = cliente;

    }

    @Override
    public void run() {

        try {
            Scanner ouvirCliente = new Scanner(cliente.getInputStream());
            PrintStream saidaCliente = new PrintStream(cliente.getOutputStream());

            String mensagem = null, username = "abb";
            mensagem = ouvirCliente.nextLine().toLowerCase();
            Map<String, String> clientes = new HashMap<String, String>();
            clientes.put(cliente.getInetAddress().getHostAddress(), username);
            
            
            saidaCliente.println("RECEBIDO: " + clientes.get(cliente.getInetAddress().getHostAddress()) + " - " + mensagem);
            clientes.remove(cliente.getInetAddress().getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
