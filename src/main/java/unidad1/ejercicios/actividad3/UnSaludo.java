package unidad1.ejercicios.actividad3;

public class UnSaludo {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("SE NECESITA UN SALUDO Y UN NÚMERO...");
			System.exit(1);
		}
		int n = Integer.parseInt(args[1]);
		for (int i = 1; i <= n; i++)
			System.out.println(i + ". " + args[0]);
	}
}
