package unidad3.ejemplos.servidorecho1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEcho {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5555);
		System.out.println("servidor escuchando");
		while (true) {
			Socket socket = serverSocket.accept();
			socket.setSoTimeout(5000);
			new AtenderCliente(socket).start();
		}
	}

}
