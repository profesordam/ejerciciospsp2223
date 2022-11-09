package unidad2.ejercicios.parque;

public class Banco {

	int plazas;
	int ocupadas;
	
	public Banco(int plazas) {
		this.plazas = plazas;
	}
	
	public synchronized void sentarse() {
		while (ocupadas == plazas) {
			System.out.println(Thread.currentThread().getName() + " tiene que esperar por una plaza libre");
			try { wait(); } catch (InterruptedException e) {}
		}
		ocupadas++;
		notifyAll();
	}
	
	public synchronized void levantarse() {
		ocupadas--;
		notifyAll();
	}
	
}
