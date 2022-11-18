package unidad2.ejercicios.secuencias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Patrón: ");
		ControlTurno control = new ControlTurno(in.readLine());
		control.start();
	}

}
