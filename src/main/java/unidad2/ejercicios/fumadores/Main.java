package unidad2.ejercicios.fumadores;

public class Main {

	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		new Thread(new Agente(mesa)).start();
		new Thread(new Fumador(mesa, Ingrediente.TABACO)).start();
		new Thread(new Fumador(mesa, Ingrediente.PAPEL)).start();
		new Thread(new Fumador(mesa, Ingrediente.CERILLAS)).start();
	}

}
