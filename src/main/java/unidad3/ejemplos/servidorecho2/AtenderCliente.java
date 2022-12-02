package unidad3.ejemplos.servidorecho2;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class AtenderCliente extends Thread {

	private Socket socket;
	
	public AtenderCliente(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		String cliente = socket.getInetAddress().toString();
		System.out.println("conexión con: " + cliente);
		try {
			String texto;
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			texto = in.readLine();
			System.out.println("echo a " + cliente + ": " + texto);
			out.println(texto);
		} catch (SocketException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (EOFException e) {
			System.out.println(cliente + " finaliza sesión");
		} catch (IOException e) {
			System.out.println(cliente + ": " + e.getLocalizedMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
