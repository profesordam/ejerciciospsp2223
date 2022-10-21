package unidad2.ejemplos;

public class HiloContadorV2 implements Runnable {

	@Override
	public void run() {
		for (int contador = 0; contador <= 5; contador++)
			System.out.println(Thread.currentThread().getName() + ", contador = " + contador);
	}
	
}
