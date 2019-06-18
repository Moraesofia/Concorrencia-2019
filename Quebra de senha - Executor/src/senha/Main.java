package senha;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static String ALPHA = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static String HASH_1 = "17a0a00212dde12b063af7dc22fdf02b";

    private static String HASH_2 = "75abfe3020804dd73a2a6040da9df96c";

    private static String HASH_3 = "c77aeec24015ad7e6e0b1db9d9deed68";

    private static Integer POOL_SIZE = 3;

    public static void main(String[] args) {
        long inicio, fim;

        byte[] alfabeto = ALPHA.getBytes();
        String hash_senha1 = HASH_1;
        String hash_senha2 = HASH_2;
        String hash_senha3 = HASH_3;

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        EncontraSenha es1 = new EncontraSenha(alfabeto, hash_senha1);
        EncontraSenha es2 = new EncontraSenha(alfabeto, hash_senha2);
        EncontraSenha es3 = new EncontraSenha(alfabeto, hash_senha3);

        inicio = System.currentTimeMillis();
        Future<String> senha1 = executor.submit(es1);
        Future<String> senha2 = executor.submit(es2);
        Future<String> senha3 = executor.submit(es3);

        try {
            System.out.println("Senha 1 -> " + senha1.get());
            System.out.println("Senha 2 -> " + senha2.get());
            System.out.println("Senha 3 -> " + senha3.get());
            fim = System.currentTimeMillis();
            long total = fim - inicio;
            System.out.println("Tempo total gasto: " + total + "ms");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class EncontraSenha implements Callable<String> {

        private static final int PASSWORD_SIZE = 5;

        private byte[] alphabetByteArray;

        private String hashOriginal;

        public EncontraSenha(byte[] alphabetByteArray, String hashOriginal) {
            super();
            this.alphabetByteArray = alphabetByteArray;
            this.hashOriginal = hashOriginal;
        }

        @Override
        public String call() throws Exception {

            byte[] novaSenhaByte = new byte[PASSWORD_SIZE];
            String hashNovaSenha = null;
            String senha = "";

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
                                hashNovaSenha = Utilitario.md5(senha);

                                if (hashNovaSenha.equals(hashOriginal)) {
                                    break laco;
                                }
                            }
                        }
                    }
                }
            }
            return senha;
        }

    }

}
