package unidad2.ejemplos;

import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Reloj extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
	private JLabel hora;

	public Reloj() {
		super("Reloj");
		hora = new JLabel();
		hora.setFont(hora.getFont().deriveFont(30f));
		hora.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(hora);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		pack();
	}

	@Override
	public void run() {
		while (true) {
			hora.setText(tf.format(LocalDateTime.now()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void iniciar() {
		setVisible(true);
		new Thread(this).start();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Reloj().iniciar();
			}
		});
	}
}
