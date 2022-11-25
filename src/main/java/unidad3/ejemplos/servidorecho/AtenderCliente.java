package unidad3.ejemplos.servidorecho;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class AtenderCliente extends Thread {

	private Socket socket;
	
	public AtenderCliente(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		System.out.println("Atendiendo cliente: " + socket.getInetAddress());
		try {
			String texto;
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				texto = in.readUTF();
				out.writeUTF(texto);
			}
		} catch (EOFException e) {
			System.out.println("Cliente " + socket.getInetAddress() + " finaliza sesión");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
