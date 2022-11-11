package unidad2.ejercicios.secuencias;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ControlTurno control = new ControlTurno();
		Scanner in = new Scanner(System.in);
		System.out.print("Patrón: ");
		Scanner patron = new Scanner(in.nextLine());
		while (patron.hasNext(".+")) {
			char c = patron.skip("\\p{Alpha}").match().group().charAt(0);
			int r = Integer.parseInt(patron.skip("\\d+").match().group());
			Turno t = new Turno(c, r);
			control.addTurno(t);
			System.out.println(t);
		}
		System.out.println("patrón escaneado");
		patron.close();
		in.close();
	}

}
