package unidad2.ejemplos.interbloqueo;

public class Consumidor extends Thread {
	private long retardo;
	private Almacen almacen;

	public Consumidor(Almacen almacen, long retardo) {
		this.retardo = retardo;
		this.almacen = almacen;
	}

	public void run() {
		while (true) {
			System.out.println(getName() + " retira " + almacen.retirar());
			try {
				Thread.sleep(retardo);
			} catch (InterruptedException e) {
			}
		}
	}
}
