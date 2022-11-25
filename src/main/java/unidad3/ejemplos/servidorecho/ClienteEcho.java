package unidad3.ejemplos.servidorecho;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteEcho {

	public static void main(String[] args) {
		System.out.println("Conectando con el servidor...");
		Socket socket = null;
		try {
			socket = new Socket("localhost", 5555);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("texto (pulsa ctrl+z para finalizar: ");
			String linea;
			while ((linea = teclado.readLine()) != null) {
				out.writeUTF(linea);
				System.out.println("echo: " + in.readUTF());
				System.out.println("texto (pulsa ctrl+z para finalizar: ");
			}
			socket.shutdownOutput();
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
	}

}
