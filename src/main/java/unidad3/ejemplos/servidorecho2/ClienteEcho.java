package unidad3.ejemplos.servidorecho2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClienteEcho {

	public static void main(String[] args) throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		System.out.print("texto (ctrl+z para salir): ");
		while ((linea = teclado.readLine()) != null) {
			System.out.println("Conectando con el servidor...");
			Socket socket = null;
			try {
				socket = new Socket("localhost", 5555);
				socket.setSoTimeout(10000);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(
						new DataOutputStream(socket.getOutputStream()));
				out.println(linea);
				socket.shutdownOutput();
				System.out.println("echo: " + in.readLine());
				socket.shutdownOutput();
			} catch (SocketException e) {
				System.out.println(e.getLocalizedMessage());
			} catch (IOException e) {
				System.out.println("no se pudo establecer la conexión con el servidor");
			} finally {
				if (socket != null)
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			System.out.print("texto (ctrl+z para salir): ");
		}
	}

}
