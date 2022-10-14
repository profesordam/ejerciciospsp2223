package unidad1.ejercicios.actividad3;

public class UnSaludo {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("SE NECESITA UN SALUDO...");
			System.exit(1);
		}
		for (int i = 1; i <= 5; i++)
			System.out.println(i + ". " + args[0]);
	}
}
