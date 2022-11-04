package unidad2.ejercicios.fumadores;

public class Fumador implements Runnable {

	Mesa mesa;
	Ingrediente ingrediente;
	
	public Fumador(Mesa mesa, Ingrediente ingrediente) {
		this.mesa = mesa;
		this.ingrediente = ingrediente;
	}

	@Override
	public void run() {
		while (true) {
			mesa.retirar(ingrediente);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
