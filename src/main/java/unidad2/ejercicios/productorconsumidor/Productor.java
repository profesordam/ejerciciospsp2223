package unidad2.ejercicios.productorconsumidor;

public class Productor extends Thread {
	private long retardo, contador = 0;
	private Almacen almacen;

	public Productor(Almacen almacen, long retardo) {
		this.retardo = retardo;
		this.almacen = almacen;
	}

	public void run() {
		while (true) {
			String producto = String.format("P%02d", ++contador);
			almacen.almacenar(producto);
			System.out.println(getName() + " almacenó " + producto);
			try {
				Thread.sleep(retardo);
			} catch (InterruptedException e) {
			}
		}
	}
}