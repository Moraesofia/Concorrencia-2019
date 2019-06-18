package br.com.moraesofia.listaTres.ex1;

/**
 * + FALTAM 4 ZEROS!!
 *
 * @author sofia
 *
 */
public class DuasThreads {

    public static void main(String[] args) {

        long tempoIni, tempoFim;
        int qntPrimos = 0;
        tempoIni = System.currentTimeMillis();

        ContaPrimos cp1 = new ContaPrimos(1_000_000, 30_000_000);
        ContaPrimos cp2 = new ContaPrimos(90_000_000, 120_000_000);

        System.out.println("Contando numeros primos entre 1.000.000 e 30.000.000 ...");
        cp1.start();
        System.out.println("Contando numeros primos entre 90.000.000 e 120.000.000 ...");
        cp2.start();

        try {
            cp1.join();
            cp2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        qntPrimos += cp1.getQuantidade();
        qntPrimos += cp2.getQuantidade();

        tempoFim = System.currentTimeMillis();
        System.out.println("Quantidade de primos identificados: " + qntPrimos);
        System.out.println(tempoFim - tempoIni + " mili seg gastos");
    }

}
