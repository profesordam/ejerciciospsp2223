package unidad2.ejemplos;

public class HiloContador extends Thread {
	public HiloContador(int id) {
		super("hilo " + id);
	}

	@Override
	public void run() {
		for (int contador = 0; contador <= 5; contador++)
			System.out.println(getName() + ", contador = " + contador);
	}
}