package unidad2.ejercicios.productorconsumidor;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Almacen almacen = new Almacen(10);
		for (int i=0; i<5; i++) {
			new Productor(almacen, 100).start();
			new Consumidor(almacen, 1000).start();
		}
	}
}
