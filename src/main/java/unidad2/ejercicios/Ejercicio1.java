package unidad2.ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio1 extends Thread {

	long milisegundos;
	
	public Ejercicio1(String nombre, long milisegundos) {
		super(nombre);
		this.milisegundos = milisegundos;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Random r = new Random();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Numero de hilos: ");
		int numHilos = Integer.parseInt(in.readLine());
		Thread [] hilos = new Thread[numHilos];
		for (int i=0; i<numHilos; i++) {
			hilos[i] = new Ejercicio1("Hilo " + i, r.nextLong(9001) + 1000); 
			hilos[i].start();
		}
		for (int i=0; i<numHilos; i++)
			hilos[i].join();
	}

	@Override
	public void run() {
		System.out.print("Hola, soy " + getName());
		System.out.println(". Voy a domir durante " + milisegundos + "ms.");
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
		}
		System.out.print("Hola, soy " + getName() + " de nuevo. ");
		System.out.println("Ya he finalizado");
	}

}
