package br.com.moraesofia.listaTres.ex1;

public class Sequencial {

    public static void main(String[] args) {

        long tempoIni, tempoFim;
        int qntPrimos = 0;
        tempoIni = System.currentTimeMillis();

        System.out.println("Contando numeros primos entre 1.000.000 e 30.000.000 ...");
        for (int i = 1_000_000; i < 30_000_000; i++) {
            if (ehPrimo(i)) {
                qntPrimos++;
                System.out.println(i);
            }
        }

        System.out.println("Contando numeros primos entre 90.000.000 e 120.000.000 ...");
        for (int i = 90_000_000; i < 120_000_000; i++) {
            if (ehPrimo(i)) {
                qntPrimos++;
                System.out.println(i);
            }
        }

        tempoFim = System.currentTimeMillis();
        System.out.println("Quantidade de primos identificados: " + qntPrimos);
        System.out.println(tempoFim - tempoIni + " mili seg gastos");

    }

    public static boolean ehPrimo(int n) {

        if ((n > 2 && n % 2 == 0) || n == 1) {
            return false;
        }

        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
