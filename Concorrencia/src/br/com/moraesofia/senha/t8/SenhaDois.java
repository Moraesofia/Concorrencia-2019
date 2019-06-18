package br.com.moraesofia.senha.t8;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import br.com.moraesofia.senha.EncontraSenha;

public class SenhaDois {

    private static String HASH_2 = "75abfe3020804dd73a2a6040da9df96c";

    public static void main(String[] args) throws InterruptedException {

        String alpha1 = "abcdefghijklmnopqrstuvwxyz0123456789";
        String alpha2 = "0123456789abcdefghijklmnopqrstuvwxyz";
        String alpha3 = "zyxwvutsrqponmlkjihgfedcba9876543210";
        String alpha4 = "9876543210zyxwvutsrqponmlkjihgfedcba";

        String alpha5 = "nopqrstuvwxyzabcdefghijklm5678901234";
        String alpha6 = "5678901234nopqrstuvwxyzabcdefghijklm";
        String alpha7 = "mlkjihgfedcbazyxwvutsrqpon4321098765";
        String alpha8 = "4321098765mlkjihgfedcbazyxwvutsrqpon";

        List<EncontraSenha> senhas = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        ThreadGroup grupo = new ThreadGroup("SenhaHash2-t8");
        byte[] hashDesejada = DatatypeConverter.parseHexBinary(HASH_2);

        EncontraSenha e1 = new EncontraSenha(alpha1, hashDesejada);
        senhas.add(e1);
        EncontraSenha e2 = new EncontraSenha(alpha2, hashDesejada);
        senhas.add(e2);
        EncontraSenha e3 = new EncontraSenha(alpha3, hashDesejada);
        senhas.add(e3);
        EncontraSenha e4 = new EncontraSenha(alpha4, hashDesejada);
        senhas.add(e4);

        EncontraSenha e5 = new EncontraSenha(alpha5, hashDesejada);
        senhas.add(e5);
        EncontraSenha e6 = new EncontraSenha(alpha6, hashDesejada);
        senhas.add(e6);
        EncontraSenha e7 = new EncontraSenha(alpha7, hashDesejada);
        senhas.add(e7);
        EncontraSenha e8 = new EncontraSenha(alpha8, hashDesejada);
        senhas.add(e8);

        Thread t1 = new Thread(grupo, e1, "Thread1");
        threads.add(t1);
        Thread t2 = new Thread(grupo, e2, "Thread2");
        threads.add(t2);
        Thread t3 = new Thread(grupo, e3, "Thread3");
        threads.add(t3);
        Thread t4 = new Thread(grupo, e4, "Thread4");
        threads.add(t4);

        Thread t5 = new Thread(grupo, e5, "Thread5");
        threads.add(t5);
        Thread t6 = new Thread(grupo, e6, "Thread6");
        threads.add(t6);
        Thread t7 = new Thread(grupo, e7, "Thread7");
        threads.add(t7);
        Thread t8 = new Thread(grupo, e8, "Thread8");
        threads.add(t8);

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
