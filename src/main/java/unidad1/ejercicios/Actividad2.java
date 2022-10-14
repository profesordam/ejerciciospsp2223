package unidad1.ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Actividad2 {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "dir");
		System.out.println(pb.environment());
		System.out.println(pb.command());
		Process p = pb.start();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
		}
	}
	
}
