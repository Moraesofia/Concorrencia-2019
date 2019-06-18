package br.com.moraesofia.listaDois;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDois {

	public static void main(String[] args) throws IOException {

		long tempoIni, tempoFim;
		tempoIni = System.currentTimeMillis();

		String linha;
		BufferedReader br = new BufferedReader(new FileReader("numeros.txt"));
		List<String> saida = new ArrayList<>();
		while ((linha = br.readLine()) != null) {
			saida.add(linha);
		}
		br.close();

		int vetor[] = new int[255];
		for (String string : saida) {
			try {
				int num = Integer.parseInt(string);
				vetor[num] +=1;
			} catch (Exception e) {
			}
			
		}
		
		int antes = 0;
		for (int j = 1; j < vetor.length; j++) {
			if (vetor[j] > vetor[antes]) {
				antes = j;
			}
		}

		int maisRepete = antes;
		tempoFim = System.currentTimeMillis();
		System.out.println("Numero que mais repete: " + maisRepete);
		System.out.println(tempoFim - tempoIni + " mili seg gastos");

	}

}
