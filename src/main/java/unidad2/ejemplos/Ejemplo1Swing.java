package unidad2.ejemplos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Ejemplo1Swing implements Runnable {

	public void run() {
        // Invoked on the event dispatching thread.
        // Construct ...
		JFrame frame = new JFrame("Ejemplo 1 de Aplicación Swing");
		Container c = frame.getContentPane();
		c.add(new JTextField("Hola Mundo!"), BorderLayout.NORTH);
		
		c.setPreferredSize(new Dimension(500, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		// ... and show GUI.
		frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Ejemplo1Swing());
    }
	
}
