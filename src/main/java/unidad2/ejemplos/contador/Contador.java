package unidad2.ejemplos.contador;

public class Contador {
	private static int n;

	public Contador(int n) {
		this.n = n;
	}

	public void inc() {
		
		//.....
		synchronized(this) {
			n++;
		}
		
		//.........
	}

	public int get() {
		return n;
	}
}