package unidad1.ejemplos;

import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();
		String comando= "notepad";
		Process p;
		p = r.exec(comando);
	}

}
