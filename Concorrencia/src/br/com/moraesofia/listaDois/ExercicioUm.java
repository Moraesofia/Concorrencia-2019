package br.com.moraesofia.listaDois;

public class ExercicioUm {

	public static void main(String[] args) {

		long tempoIni, tempoFim;
		double pi = 1;
		double d = 3;
		tempoIni = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++) {
			if (i % 2 == 0) {
				pi -= 1 / d;
				d += 2;
			} else {
				pi += 1 / d;
				d += 2;
			}
		}

		tempoFim = System.currentTimeMillis();
		System.out.println(pi * 4);
		System.out.println(tempoFim - tempoIni + " mili seg gastos");
	}

}
