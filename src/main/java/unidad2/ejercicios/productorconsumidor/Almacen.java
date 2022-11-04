package unidad2.ejercicios.productorconsumidor;

public class Almacen {
	private int ultimo = -1;
	private String[] productos;

	public Almacen(int capacidad) {
		productos = new String[capacidad];
	}

	public synchronized void almacenar(String producto) {
		while (ultimo == productos.length - 1)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		productos[++ultimo] = producto;
		notifyAll();
	}

	public synchronized String retirar() {
		while (ultimo == -1) // almacén vacío
			try {
				wait();
			} catch (InterruptedException e) {
			}
		String producto = productos[ultimo--];
		notifyAll();
		return producto;
	}
}
