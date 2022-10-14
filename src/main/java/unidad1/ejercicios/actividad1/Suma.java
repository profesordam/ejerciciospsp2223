package unidad1.ejercicios.actividad1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Suma {
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static String linea;
	
	public static void main(String[] args) throws IOException {
		try {
			double n1 = leerNumero("Número 1: ");
			double n2 = leerNumero("Número 2: ");
			System.out.printf("%f + %f = %f\n", n1, n2, n1 + n2);
		} catch (NumberFormatException e) {
			System.err.printf("error: %s no es un número\n", linea);
			System.exit(-1);
		}
	}
	
	private static double leerNumero(String texto) throws IOException {
		System.out.print(texto);
		linea = in.readLine();
		return Double.parseDouble(linea);
	}

}
