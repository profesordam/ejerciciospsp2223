package unidad2.ejercicios.parque.locks;

public class Persona extends Thread {

	Banco banco;
	
	Persona (String nombre, Banco banco) {
		super(nombre);
		this.banco = banco;
	}
	
	@Override
	public void run() {
		long t = (long) (Math.random() * 3000 + 1000);
		System.out.println(getName() + " va a pasear durante " + t + " milisegundos");
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {}
		System.out.println(getName() + " ha llegado al banco");
		banco.sentarse();
		t = (long) (Math.random() * 700 + 2000);
		System.out.println(getName() + " se ha sentado, descansará durante " + t + " milisegundos");
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {}
		System.out.println(getName() + " se levanta del banco");
		banco.levantarse();
	}
	
}
