package unidad2.ejemplos.interbloqueo;

public class Almacen {
	private int ultimo = -1;
	private String[] productos;

	public Almacen(int capacidad) {
		productos = new String[capacidad];
	}

	public synchronized void almacenar(String producto) {
		while (ultimo == productos.length - 1)
			; // almacén lleno
		productos[++ultimo] = producto;
		notify();
	}

	public synchronized String retirar() {
		while (ultimo == -1)
			; // almacén vacío
		String producto = productos[ultimo--];
		return producto;
	}
}
