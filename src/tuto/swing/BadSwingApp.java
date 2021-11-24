// BadSwingApp.java
package tuto.swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BadSwingApp extends JFrame {
	JComboBox<String> combo = new JComboBox<>();

	public BadSwingApp(String title) {
		super(title);
		initFrame();
	}

	private void initFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.add(combo, BorderLayout.NORTH);
		
		// Add an ItemEvent listener to the combobox
		combo.addItemListener(
				e -> System.out.println("isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread()));
		combo.addItem("First");
		combo.addItem("Second");
		combo.addItem("Third");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				BadSwingApp badSwingApp = new BadSwingApp("A bad Swing App");
				badSwingApp.pack();
				badSwingApp.setVisible(true);
				
			} 
		
		});
	}
}
