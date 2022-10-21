package unidad2.ejemplos;

public class EjemploInterrupt implements Runnable {
	
	Thread hiloPrincipal;
	
	public EjemploInterrupt(Thread hiloPrincipal) {
		this.hiloPrincipal = hiloPrincipal;
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Estado del hilo principal: " + hiloPrincipal.getState());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread h = new Thread(new EjemploInterrupt(Thread.currentThread()));
		h.start();
		Thread.sleep(1000);
		h.interrupt();
		h.join();
		System.out.println("hilo finalizado");
	}
	
}