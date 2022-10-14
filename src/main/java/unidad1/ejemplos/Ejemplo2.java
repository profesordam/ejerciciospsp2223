package unidad1.ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {
	
	public static void main(String[] args) throws IOException,
	InterruptedException {
	Runtime r = Runtime.getRuntime();
	Process p = r.exec( "cmd /C dir c:\\" );
	InputStream is = p.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	String linea;
	while((linea = br.readLine()) != null)
		System.out.println(linea);
	br.close();
	int exitCode = p.waitFor();
	System.out.println("código de salida: " + exitCode);
	if (exitCode != 0)
		try (BufferedReader inErr = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
		String lineErr = null;
		while ((lineErr = inErr.readLine()) != null)
		System.out.println("ERROR >" + lineErr);
		}
	}
	
}
