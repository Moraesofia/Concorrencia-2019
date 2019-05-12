package br.com.moraesofia.senha;

import java.util.Arrays;

@SuppressWarnings("unused")
public class EncontraSenha implements Runnable {

    private static final int PASSWORD_SIZE = 5;

    private long tempoInicial;

    private long tempoFinal;

    private String nome;

    private boolean encontrada;

    private byte[] alphabetByteArray;

    private byte[] hashOriginal;

    public EncontraSenha(String alfabeto, byte[] hash) {
        this.alphabetByteArray = alfabeto.getBytes();
        this.hashOriginal = hash;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        byte[] novaSenhaByte = new byte[PASSWORD_SIZE];
        byte[] hashNovaSenha = null;
        String senha = "";
        encontrada = false;
        nome = Thread.currentThread().getName();

        tempoInicial = System.currentTimeMillis();
        laco: for (byte b1 : alphabetByteArray) {
            for (byte b2 : alphabetByteArray) {
                for (byte b3 : alphabetByteArray) {
                    for (byte b4 : alphabetByteArray) {
                        for (byte b5 : alphabetByteArray) {
                            novaSenhaByte[0] = b1;
                            novaSenhaByte[1] = b2;
                            novaSenhaByte[2] = b3;
                            novaSenhaByte[3] = b4;
                            novaSenhaByte[4] = b5;

                            senha = new String(novaSenhaByte);
                            hashNovaSenha = Utilitario.md5(novaSenhaByte);

                            if (Arrays.equals(hashNovaSenha, hashOriginal)) {
                                encontrada = true;
                                System.out.println(senha);
                                tempoFinal = System.currentTimeMillis();
                                break laco;
                            }
                        }
                    }
                }
            }
        }
        Thread.currentThread().getThreadGroup().stop();
        // Fim do metodo "run"
    }

    public long getTempoTotal() {
        return tempoFinal - tempoInicial;
    }

    public boolean isEncontrada() {
        return encontrada;
    }

    public String getNome() {
        return nome;
    }
}
