package unidad3.ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class EjemploURL {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.educastur.es");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
		}
	}

}
