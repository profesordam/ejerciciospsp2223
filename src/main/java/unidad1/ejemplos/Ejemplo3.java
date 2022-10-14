package unidad1.ejemplos;

import java.io.IOException;
import java.io.OutputStream;

public class Ejemplo3 {

	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("cmd /C date");
		try (OutputStream os = process.getOutputStream()) {
			os.write(("01-01-22" + System.getProperty("line.separator")).getBytes());
			os.flush();
		}
	}
	
}
