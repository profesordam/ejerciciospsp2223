package unidad2.ejercicios.fumadores;

import java.util.Random;

public enum Ingrediente {
	TABACO, PAPEL, CERILLAS;
	
	private static Random r = new Random();
	
	public static Ingrediente random() {
		return values()[r.nextInt(3)];
	}
	
	public static Ingrediente random(Ingrediente ingrediente) {
		Ingrediente aux;
		while ((aux = random()) == ingrediente);
		return aux;
	}
}
