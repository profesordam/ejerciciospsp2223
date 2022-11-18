package unidad2.ejercicios.secuencias;

public class EscribeLetras extends Thread {

	ControlTurno control;
	char letra;
	
	public EscribeLetras(ControlTurno control, char letra) {
		this.control = control;
		this.letra = letra;
	}
	
	@Override
	public void run() {
		while (true) {
			int n = control.getTurno(letra);
			for (int i=0; i<n; i++) {
				System.out.print(letra);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			control.pasarTurno();
		}
	}
	
}
