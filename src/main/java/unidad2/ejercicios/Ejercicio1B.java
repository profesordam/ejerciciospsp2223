package unidad2.ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Ejercicio1B implements Runnable {

	String nombre;
	long milisegundos;
	
	public Ejercicio1B(String nombre, long milisegundos) {
		this.nombre = nombre;
		this.milisegundos = milisegundos;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Random r = new Random();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Numero de hilos: ");
		int numHilos = Integer.parseInt(in.readLine());
		Thread [] hilos = new Thread[numHilos];
		for (int i=0; i<numHilos; i++) {
			hilos[i] = new Thread(new Ejercicio1B("Hilo " + i, r.nextLong(9001) + 1000)); 
			hilos[i].start();
		}
		for (int i=0; i<numHilos; i++)
			hilos[i].join();
	}

	@Override
	public void run() {
		Thread.currentThread().setName(nombre);
		System.out.print("Hola, soy " + Thread.currentThread().getName());
		System.out.println(". Voy a domir durante " + milisegundos + "ms.");
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
		}
		System.out.print("Hola, soy " + Thread.currentThread().getName() + " de nuevo. ");
		System.out.println("Ya he finalizado");
	}

}
