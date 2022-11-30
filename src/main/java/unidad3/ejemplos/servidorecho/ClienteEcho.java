package unidad3.ejemplos.servidorecho;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

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
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(linea);
				socket.shutdownOutput();
				System.out.println("echo: " + in.readUTF());
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
