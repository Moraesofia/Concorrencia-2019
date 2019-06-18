package br.com.moraesofia.senha.t16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

import br.com.moraesofia.senha.EncontraSenha;
import br.com.moraesofia.senha.Utilitario;

public class SenhaDois {

    private static String HASH_2 = "75abfe3020804dd73a2a6040da9df96c";

    public static void main(String[] args) throws InterruptedException {

        long seed = 1L;
        Random r = new Random(seed);

        String alpha1 = "abcdefghijklmnopqrstuvwxyz0123456789";
        String alpha2 = "0123456789abcdefghijklmnopqrstuvwxyz";
        String alpha3 = "zyxwvutsrqponmlkjihgfedcba9876543210";
        String alpha4 = "9876543210zyxwvutsrqponmlkjihgfedcba";

        String alpha5 = "nopqrstuvwxyzabcdefghijklm5678901234";
        String alpha6 = "5678901234nopqrstuvwxyzabcdefghijklm";
        String alpha7 = "mlkjihgfedcbazyxwvutsrqpon4321098765";
        String alpha8 = "4321098765mlkjihgfedcbazyxwvutsrqpon";

        String alpha9 = Utilitario.shuffleString(alpha1, r); // wh0publajift8evzy63mqcdnxr9k2o5g41s7
        String alpha10 = Utilitario.shuffleString(alpha2, r); // 4m2libvn7uyepj8qx3hdazw0tc95rk1s6gof
        String alpha11 = Utilitario.shuffleString(alpha3, r); // zxp5ca40sbdfjo8kg6w9u7213eirymvhnlqt
        String alpha12 = Utilitario.shuffleString(alpha4, r); // 0maipx539bus7jgh1el2qtwrc46z8kofvndy

        String alpha13 = Utilitario.shuffleString(alpha5, r);// 259xmahsqb1yuwonf8pit60k7j4legz3dcvr
        String alpha14 = Utilitario.shuffleString(alpha6, r);// v19l4rtegpankodjbuf5wqiyc86mzxsh3207
        String alpha15 = Utilitario.shuffleString(alpha7, r);// sqz9xwnbv1rt78h0j6e5uakdyim4opf23glc
        String alpha16 = Utilitario.shuffleString(alpha8, r);// 0rhs948t5kgnvb6duomxz71aliw2j3qfpyec

        List<EncontraSenha> senhas = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        ThreadGroup grupo = new ThreadGroup("SenhaHash2-t16");
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

        EncontraSenha e9 = new EncontraSenha(alpha9, hashDesejada);
        senhas.add(e9);
        EncontraSenha e10 = new EncontraSenha(alpha10, hashDesejada);
        senhas.add(e10);
        EncontraSenha e11 = new EncontraSenha(alpha11, hashDesejada);
        senhas.add(e11);
        EncontraSenha e12 = new EncontraSenha(alpha12, hashDesejada);
        senhas.add(e12);

        EncontraSenha e13 = new EncontraSenha(alpha13, hashDesejada);
        senhas.add(e13);
        EncontraSenha e14 = new EncontraSenha(alpha14, hashDesejada);
        senhas.add(e14);
        EncontraSenha e15 = new EncontraSenha(alpha15, hashDesejada);
        senhas.add(e15);
        EncontraSenha e16 = new EncontraSenha(alpha16, hashDesejada);
        senhas.add(e16);

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

        Thread t9 = new Thread(grupo, e9, "Thread9");
        threads.add(t9);
        Thread t10 = new Thread(grupo, e10, "Thread10");
        threads.add(t10);
        Thread t11 = new Thread(grupo, e11, "Thread11");
        threads.add(t11);
        Thread t12 = new Thread(grupo, e12, "Thread12");
        threads.add(t12);

        Thread t13 = new Thread(grupo, e13, "Thread13");
        threads.add(t13);
        Thread t14 = new Thread(grupo, e14, "Thread14");
        threads.add(t14);
        Thread t15 = new Thread(grupo, e15, "Thread15");
        threads.add(t15);
        Thread t16 = new Thread(grupo, e16, "Thread16");
        threads.add(t16);

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
