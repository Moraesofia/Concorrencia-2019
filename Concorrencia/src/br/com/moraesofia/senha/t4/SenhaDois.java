package br.com.moraesofia.senha.t4;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import br.com.moraesofia.senha.EncontraSenha;

public class SenhaDois {

    private static String HASH_2 = "75abfe3020804dd73a2a6040da9df96c";

    public static void main(String[] args) throws InterruptedException {

        String alpha1 = "abcdefghijklmnopqrstuvwxyz0123456789";
        String alpha2 = "mlkjihgfedcbazyxwvutsrqpon4321098765";
        String alpha3 = "zyxwvutsrqponmlkjihgfedcba9876543210";
        String alpha4 = "9876543210zyxwvutsrqponmlkjihgfedcba";

        List<EncontraSenha> senhas = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        ThreadGroup grupo = new ThreadGroup("SenhaHash2-t4");
        byte[] hashDesejada = DatatypeConverter.parseHexBinary(HASH_2);

        EncontraSenha e1 = new EncontraSenha(alpha1, hashDesejada);
        senhas.add(e1);
        EncontraSenha e2 = new EncontraSenha(alpha2, hashDesejada);
        senhas.add(e2);
        EncontraSenha e3 = new EncontraSenha(alpha3, hashDesejada);
        senhas.add(e3);
        EncontraSenha e4 = new EncontraSenha(alpha4, hashDesejada);
        senhas.add(e4);

        Thread t1 = new Thread(grupo, e1, "Thread1");
        threads.add(t1);
        Thread t2 = new Thread(grupo, e2, "Thread2");
        threads.add(t2);
        Thread t3 = new Thread(grupo, e3, "Thread3");
        threads.add(t3);
        Thread t4 = new Thread(grupo, e4, "Thread4");
        threads.add(t4);

        for (Thread t : threads) {
            System.out.println("Iniciada: " + t.getName());
            t.start();
        }
        System.out.println("---------------------------");

        for (Thread t : threads) {
            t.join();
        }

        for (EncontraSenha e : senhas) {
            if (e.isEncontrada()) {
                System.out.println("Senha 2 enontrada pela thread: " + e.getNome());
                System.out.println("Tempo total gasto: " + e.getTempoTotal());

            }
        }

    }

}
