package unidad2.ejemplos;

public class TestHiloContadorV2 {
	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++)
			new Thread(new HiloContadorV2() ,"hilo " + i).start();
	}
}