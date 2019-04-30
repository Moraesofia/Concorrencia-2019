package br.com.moraesofia.listaDois;

/**
 * Lista Dois - Ex. 6.
 * 
 * @author sofia
 *
 */
public class TesteContador {

    public static void main(String[] args) {

        ContaPrimos c1 = new ContaPrimos();
        ContaPrimos c2 = new ContaPrimos();
        ContaPrimos c3 = new ContaPrimos();

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }

}
