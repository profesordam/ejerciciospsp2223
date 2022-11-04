package unidad2.ejercicios.fumadores;

import java.util.HashSet;
import java.util.Set;

public class Mesa {

	Set<Ingrediente> ingredientes = new HashSet<>();
	
	public synchronized void colocar(Ingrediente i1, Ingrediente i2) {
		while (!ingredientes.isEmpty())
			try {
				wait();
			} catch (InterruptedException e) {
			}
		ingredientes.add(i1);
		ingredientes.add(i2);
		System.out.println("El agente pone en la mesa " + i1 + " y " + i2);
		notifyAll();
	}
	
	public synchronized void retirar(Ingrediente i) {
		while (ingredientes.isEmpty() || ingredientes.contains(i))
			try {
				wait();
			} catch (InterruptedException e) {
			}
		System.out.println("El fumador con " + i + " retira de la mesa el resto de ingredientes");
		ingredientes.clear();
		notifyAll();
	}
	
}
