package unidad2.ejercicios.fumadores;

public class Agente implements Runnable {

	Mesa mesa;
	
	public Agente(Mesa mesa) {
		this.mesa = mesa;
	}

	@Override
	public void run() {
		while (true) {
			Ingrediente i = Ingrediente.random();
			mesa.colocar(i, Ingrediente.random(i));
		}
	}

}
