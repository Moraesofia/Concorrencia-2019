package br.com.moraesofia.listaTres.ex1;

public class SeisThreads {

    public static void main(String[] args) {
        long tempoIni, tempoFim;
        int qntPrimos = 0;
        tempoIni = System.currentTimeMillis();

        ContaPrimos cp1 = new ContaPrimos(1000000, 10000000);
        ContaPrimos cp2 = new ContaPrimos(10000001, 20000000);
        ContaPrimos cp3 = new ContaPrimos(20000001, 30000000);
        ContaPrimos cp4 = new ContaPrimos(90000000, 100000000);
        ContaPrimos cp5 = new ContaPrimos(100000001, 110000000);
        ContaPrimos cp6 = new ContaPrimos(110000001, 120000000);

        System.out.println("Contando numeros primos entre 1000000 e 10000000 ...");
        cp1.start();
        System.out.println("Contando numeros primos entre 10000001 e 20000000 ...");
        cp2.start();
        System.out.println("Contando numeros primos entre 20000001 e 30000000 ...");
        cp3.start();
        System.out.println("Contando numeros primos entre 90000000 e 100000000 ...");
        cp4.start();
        System.out.println("Contando numeros primos entre 100000001 e 110000000 ...");
        cp5.start();
        System.out.println("Contando numeros primos entre 110000001 e 120000000 ...");
        cp6.start();

        try {
            cp1.join();
            cp2.join();
            cp3.join();
            cp4.join();
            cp5.join();
            cp6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        qntPrimos += cp1.getQuantidade();
        qntPrimos += cp2.getQuantidade();
        qntPrimos += cp3.getQuantidade();
        qntPrimos += cp4.getQuantidade();
        qntPrimos += cp5.getQuantidade();
        qntPrimos += cp6.getQuantidade();

        tempoFim = System.currentTimeMillis();
        System.out.println("Quantidade de primos identificados: " + qntPrimos);
        System.out.println(tempoFim - tempoIni + " mili seg gastos");
    }

}
