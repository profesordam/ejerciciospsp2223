package unidad3.ejemplos.servidorecho;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
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
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			texto = in.readUTF();
			System.out.println("echo a " + cliente + ": " + texto);
			out.writeUTF(texto);
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
