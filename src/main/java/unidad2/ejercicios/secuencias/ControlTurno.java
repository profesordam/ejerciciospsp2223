package unidad2.ejercicios.secuencias;

import java.util.LinkedList;
import java.util.Queue;

public class ControlTurno {

	Queue<Turno> cola = new LinkedList<>();
	
	public void addTurno(Turno t) {
		cola.offer(t);
	}
	
	public Turno getTurno() {
		
	}
	
	public void parsarTurno() {
		
	}
	
}
