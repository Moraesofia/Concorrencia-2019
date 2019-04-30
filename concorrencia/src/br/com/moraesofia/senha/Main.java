package br.com.moraesofia.senha;

public class Main {

    private static int PASSWORD_SIZE = 5;

    private static String alphabetString = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static String HASH_1 = "17a0a00212dde12b063af7dc22fdf02b";

    private static String HASH_2 = "75abfe3020804dd73a2a6040da9df96c";

    private static String HASH_3 = "c77aeec24015ad7e6e0b1db9d9deed68";

    private static long tempoTotal;

    public static void main(String[] args) {
        long inicio, fim;

        // char[] alphabetCharArray = alphabetString.toCharArray();
        // char[] novaSenhaChar = new char[PASSWORD_SIZE];

        byte[] alphabetByteArray = alphabetString.getBytes();

        /**
         * ---------------- SENHA 1
         */
        inicio = System.currentTimeMillis();

        descobreSenha(alphabetByteArray, HASH_1);

        fim = System.currentTimeMillis();
        tempoTotal += (fim - inicio);

        System.out.println(fim - inicio + " mili seg gastos para senha 1");

        /**
         * ---------------- SENHA 2
         */
        inicio = System.currentTimeMillis();

        descobreSenha(alphabetByteArray, HASH_2);

        fim = System.currentTimeMillis();
        tempoTotal += (fim - inicio);

        System.out.println(fim - inicio + " mili seg gastos para senha 2");

        /**
         * ---------------- SENHA 3
         */
        inicio = System.currentTimeMillis();

        descobreSenha(alphabetByteArray, HASH_3);

        fim = System.currentTimeMillis();
        tempoTotal += (fim - inicio);

        System.out.println(fim - inicio + " mili seg gastos para senha 3");

        System.out.println("---------------------------");
        System.out.println("Tempo total gasto: " + tempoTotal);

    }

    public static void descobreSenha(byte[] alphabetByteArray, String hashOriginal) {
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
                                System.out.println(senha);
                                break laco;
                            }

                        }
                    }
                }
            }
        }
        // return senha;
    }

    // public static String shuffleString(String string) {
    // List<String> letters = Arrays.asList(string.split(""));
    // Collections.shuffle(letters);
    // String shuffled = "";
    // for (String letter : letters) {
    // shuffled += letter;
    // }
    // return shuffled;
    // }

    // for (char c1 : alphabetCharArray) {
    // for (char c2 : alphabetCharArray) {
    // for (char c3 : alphabetCharArray) {
    // for (char c4 : alphabetCharArray) {
    // for (char c5 : alphabetCharArray) {
    //
    // }
    // }
    // }
    // }
    // }
}
