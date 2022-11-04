package unidad2.ejercicios;

/*
 * Crear un programa Java que ejecute dos hilos:
 * 
 *     Uno de ellos repetirá de forma indefinida la impresión en la consola
 *     de la palabra TIC a intervalos de un segundo.
 * 
 *     El otro hará lo mismo con la palabra TAC.
 *     
 * Define una única clase que permita crear ambos hilos.
 * 
 * ¿Se visualizarán los textos TIC y TAC perfectamente alternados: TIC TAC TIC TAC …?
 * 
 */

public class TicTac implements Runnable {
	
	String sonido;
	
	public TicTac(String sonido) {
		this.sonido = sonido;
	}

	@Override
	public void run() {
		while (true) {
			System.out.print(sonido + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new TicTac("TIC")).start();
		new Thread(new TicTac("TAC")).start();
	}

}
