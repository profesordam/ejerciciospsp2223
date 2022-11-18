package unidad2.ejercicios.parque.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {

	Lock lock = new ReentrantLock();
	Condition libre = lock.newCondition();
	int plazas;
	int ocupadas;
	
	public Banco(int plazas) {
		this.plazas = plazas;
	}
	
	public void sentarse() {
		try {
			lock.lock();
			while (ocupadas == plazas) {
				System.out.println(Thread.currentThread().getName() + " tiene que esperar por una plaza libre");
				try { libre.await(); } catch (InterruptedException e) {}
			}
			ocupadas++;
		} finally {
			lock.unlock();
		}
	}
	
	public void levantarse() {
		try {
			lock.lock();
			ocupadas--;
			libre.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
}
