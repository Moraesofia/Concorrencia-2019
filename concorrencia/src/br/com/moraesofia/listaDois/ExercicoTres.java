package br.com.moraesofia.listaDois;

public class ExercicoTres {

	public static void main(String[] args) {
		long tempoIni, tempoFim;
		tempoIni = System.currentTimeMillis();

		for (int i = 1; i < 300000; i++) {
			if (isPrimo(i)) {
				System.out.println(i);
			}
		}

		tempoFim = System.currentTimeMillis();
		System.out.println(tempoFim - tempoIni + " mili seg gastos");

	}

	private static boolean isPrimo(int numero) {
		for (int j = 2; j < numero; j++) {
			if (numero % j == 0)
				return false;
		}
		return true;
	}

}
