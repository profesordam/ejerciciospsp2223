package unidad2.ejercicios.secuencias;

public class Turno {
	char letra;
	int repeticiones;
	
	public Turno(char letra, int repeticiones) {
		super();
		this.letra = letra;
		this.repeticiones = repeticiones;
	}
	
	public char getLetra() {
		return letra;
	}
	
	public int getRepeticiones() {
		return repeticiones;
	}
	
	@Override
	public String toString() {
		return (String.valueOf(letra) + repeticiones);
	}
}
