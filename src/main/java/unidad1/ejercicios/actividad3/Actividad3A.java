package unidad1.ejercicios.actividad3;

import java.io.IOException;

public class Actividad3A {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", "unidad1.ejercicios.actividad3.UnSaludo");
		Process p = pb.start();
		String path = System.getProperty("user.home") + "\\Escritorio\\actividad3a.txt";
		
	}
	
}
