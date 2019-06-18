package br.com.moraesofia.listaDois;

import java.util.ArrayList;
import java.util.List;

/**
 * Lista Dois - Ex. 5.
 * 
 * @author sofia
 *
 */
public class ExercicioCinco {

    public static void main(String[] args) {

        List<T1> threads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            T1 t1 = new T1(i);
            threads.add(t1);
        }

        for (T1 t1 : threads) {
            t1.start();
        }

    }

}
