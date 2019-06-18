package br.com.moraesofia.listaTres.ex1;

/**
 * Auxiliar à classe "ExercicioUm".
 *
 * @author sofia
 *
 */
public class ContaPrimos extends Thread {

    private int quantidade;

    private int inicio;

    private int fim;

    public ContaPrimos(int inicio, int fim) {
        super();
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                this.quantidade++;
                System.out.println(i);
            }
        }

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

    public int getQuantidade() {
        return quantidade;
    }

}
