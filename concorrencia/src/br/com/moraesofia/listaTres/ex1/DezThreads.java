package br.com.moraesofia.listaTres.ex1;

public class DezThreads {
    public static void main(String[] args) {
        long tempoIni, tempoFim;
        int qntPrimos = 0;
        tempoIni = System.currentTimeMillis();

        ContaPrimos cp1 = new ContaPrimos(1000000, 6000000);
        ContaPrimos cp2 = new ContaPrimos(6000001, 12000000);
        ContaPrimos cp3 = new ContaPrimos(12000001, 18000000);
        ContaPrimos cp4 = new ContaPrimos(18000001, 24000000);
        ContaPrimos cp5 = new ContaPrimos(24000001, 30000000);

        ContaPrimos cp6 = new ContaPrimos(90000000, 96000000);
        ContaPrimos cp7 = new ContaPrimos(96000001, 102000000);
        ContaPrimos cp8 = new ContaPrimos(102000001, 108000000);
        ContaPrimos cp9 = new ContaPrimos(108000001, 114000000);
        ContaPrimos cp10 = new ContaPrimos(114000001, 120000000);

        System.out.println("Contando numeros primos entre 1000000 e 6000000 ...");
        cp1.start();
        System.out.println("Contando numeros primos entre 6000001 e 12000000 ...");
        cp2.start();
        System.out.println("Contando numeros primos entre 12000001 e 18000000 ...");
        cp3.start();
        System.out.println("Contando numeros primos entre 18000001 e 24000000 ...");
        cp4.start();
        System.out.println("Contando numeros primos entre 24000001 e 30000000 ...");
        cp5.start();

        System.out.println("Contando numeros primos entre 90000000 e 96000000 ...");
        cp6.start();
        System.out.println("Contando numeros primos entre 96000001 e 102000000 ...");
        cp7.start();
        System.out.println("Contando numeros primos entre 102000001 e 108000000 ...");
        cp8.start();
        System.out.println("Contando numeros primos entre 108000001 e 114000000 ...");
        cp9.start();
        System.out.println("Contando numeros primos entre 114000001 e 120000000 ...");
        cp10.start();

        try {
            cp1.join();
            cp2.join();
            cp3.join();
            cp4.join();
            cp5.join();

            cp6.join();
            cp7.join();
            cp8.join();
            cp9.join();
            cp10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        qntPrimos += cp1.getQuantidade();
        qntPrimos += cp2.getQuantidade();
        qntPrimos += cp3.getQuantidade();
        qntPrimos += cp4.getQuantidade();
        qntPrimos += cp5.getQuantidade();

        qntPrimos += cp6.getQuantidade();
        qntPrimos += cp7.getQuantidade();
        qntPrimos += cp8.getQuantidade();
        qntPrimos += cp9.getQuantidade();
        qntPrimos += cp10.getQuantidade();

        tempoFim = System.currentTimeMillis();
        System.out.println("Quantidade de primos identificados: " + qntPrimos);
        System.out.println(tempoFim - tempoIni + " mili seg gastos");
    }
}
