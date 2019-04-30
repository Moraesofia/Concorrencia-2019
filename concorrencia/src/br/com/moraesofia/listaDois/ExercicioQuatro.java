package br.com.moraesofia.listaDois;

/**
 * Lista Dois - Ex. 4.
 * 
 * @author sofia
 *
 */
public class ExercicioQuatro {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            escreveMensagem();
        }

    }

    public static void escreveMensagem() {
        new Thread() {

            @Override
            public void run() {
                System.out.println(getName());
            }
        }.start();

    }

}
