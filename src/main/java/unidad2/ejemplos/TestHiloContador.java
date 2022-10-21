package unidad2.ejemplos;

public class TestHiloContador {
	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++)
			new HiloContador(i).start();
	}
}