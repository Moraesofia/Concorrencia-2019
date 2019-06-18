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

public class AtenderCliente extends Thread {

    private Socket cliente;

    private static List<Usuario> usuarios = new ArrayList<>();

    private String nome;

    private static String SEPARADOR = ":";

    private static String SEPARADOR_USUARIOS = ",";

    private static String PARA_TODOS = "*";

    private static String SAIR = "command:remove";

    private static String VER_USUARIOS = "command:friends";

    private boolean condicao;

    public AtenderCliente(Socket cliente) {
        this.cliente = cliente;
        this.condicao = true;
    }

    @Override
    public void run() {

        try {

            Scanner ouvirCliente = new Scanner(cliente.getInputStream());
            PrintStream saidaCliente = new PrintStream(cliente.getOutputStream());

            String mensagem = null;
            saidaCliente.println("Digite seu nome: ");
            nome = mensagem = ouvirCliente.nextLine();

            // Cria Usuario e adiciona na lista
            Usuario user = new Usuario(nome, saidaCliente);
            usuarios.add(user);

            // Mensagem de boas vindas
            saidaCliente.println("Bem vindo " + user.getNome()
                    + " ao WhatsUFG! ## Digite 'command:remove' para sair e 'command:friends' para uma lista de todos os usuários conectados ##");

            mensagem = nome + " entrou no chat";
            sendAll(saidaCliente, mensagem);

            while (condicao) {
                mensagem = null;
                mensagem = ouvirCliente.nextLine();

                if (mensagem.replace(" ", "").equalsIgnoreCase(SAIR)) {
                    sendAll(saidaCliente, nome + "deixou o chat");
                    // Remove o usuário da lista
                    usuarios.remove(user);
                    ouvirCliente.close();
                    condicao = false;

                } else if (mensagem.replace(" ", "").equals(VER_USUARIOS)) {
                    // Retorna lista de usuarios
                    saidaCliente.println(getUsuarios());

                } else if (mensagem.contains(SEPARADOR)) {
                    // Contem o separador
                    String[] array = mensagem.split(SEPARADOR);
                    String msg = array[1].trim();

                    if (array[0].contains(PARA_TODOS)) {
                        // Mensagem para todos os usuários
                        sendAll(saidaCliente, msg);
                    } else {
                        // Saida para usuarios específicos
                        String[] users = array[0].replace(" ", "").split(SEPARADOR_USUARIOS);
                        sendToAFew(users, saidaCliente, msg);
                    }
                } else {
                    // Broadcast
                    sendAll(saidaCliente, mensagem);
                }
            }
        } catch (Exception e) {
            sendAll(null, "#" + nome + " deixou o chat #");
        }
    }

    public void sendAll(PrintStream saidaCliente, String mensagem) {
        for (Usuario usuario : usuarios) {
            PrintStream s = usuario.getSaidaCliente();
            if (!(s == saidaCliente)) {
                s.println(nome + " -> " + mensagem);
            }
        }
    }

    public void sendToAFew(String[] receptores, PrintStream saidaCliente, String mensagem) {
        for (Usuario usuario : usuarios) {
            for (int i = 0; i < receptores.length; i++) {
                if (usuario.getNome().equalsIgnoreCase(receptores[i])) {
                    usuario.getSaidaCliente().println(nome + " -> " + mensagem);
                }
            }
        }
    }

    public String getUsuarios() {
        StringBuilder users = new StringBuilder();
        users.append("users: ");
        int i = 0;
        for (Usuario u : usuarios) {
            users.append(u.getNome());
            if (i < usuarios.size() - 1) {
                users.append(", ");
            }
            i++;
        }
        return users.toString();
    }

}
