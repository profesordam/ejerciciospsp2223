package unidad2.ejercicios.secuencias;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ControlTurno {

	Queue<Turno> cola = new LinkedList<>();
	Map<Character, EscribeLetras> hilos = new HashMap<>();
	
	public ControlTurno(String patron) {
		Scanner s = new Scanner(patron);
		while (s.hasNext(".+")) {
			char c = s.skip("\\p{Alpha}").match().group().charAt(0);
			if (!hilos.containsKey(c))
				hilos.put(c, new EscribeLetras(this, c));
			int r = Integer.parseInt(s.skip("\\d+").match().group());
			Turno t = new Turno(c, r);
			addTurno(t);
		}
		s.close();
	}
	
	public void start() {
		hilos.values().forEach(hilo -> hilo.start());
	}
	
	public void addTurno(Turno t) {
		cola.offer(t);
	}
	
	public synchronized int getTurno(char letra) {
		Turno turno;
		while ((turno = cola.peek()).getLetra() != letra)
			try {
				wait();
			} catch (InterruptedException e) {}
		return turno.getRepeticiones();
	}
	
	public synchronized void pasarTurno() {
		cola.offer(cola.poll());
		notifyAll();
	}
	
}
