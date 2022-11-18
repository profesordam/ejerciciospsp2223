package unidad2.ejercicios.parque.locks;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Número de plazas: ");
		Banco banco = new Banco(s.nextInt());
		System.out.println("Número de personas: ");
		int n = s.nextInt();
		for (int i=0; i<n; i++)
			new Persona("Persona " + (i + 1), banco).start();
	}

}
