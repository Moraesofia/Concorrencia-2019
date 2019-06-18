package br.com.moraesofia.chat;

import java.io.PrintStream;

public class Usuario {

    private String nome;

    private PrintStream saidaCliente;

    public Usuario(String nome, PrintStream saidaCliente) {
        super();
        this.nome = nome;
        this.saidaCliente = saidaCliente;
    }

    public String getNome() {
        return nome;
    }

    public PrintStream getSaidaCliente() {
        return saidaCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaidaCliente(PrintStream saidaCliente) {
        this.saidaCliente = saidaCliente;
    }

}
