package unidad1.ejercicios.actividad1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class EjecutaSuma {

	public static void main(String[] args) throws InterruptedException, IOException {
		Process process = Runtime.getRuntime().exec("java -classpath target/classes unidad1.ejercicios.actividad1.Suma");
		try (OutputStream os = process.getOutputStream()) {
			os.write("1\n2\n".getBytes());
			os.flush();
		}
		int estado = process.waitFor();

		if (estado != 0)
			try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
				String linea;
				while ((linea = in.readLine()) != null)
					System.out.println(linea);
			}
		try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
		}
	}

}