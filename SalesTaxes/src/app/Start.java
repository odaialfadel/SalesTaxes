package app;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import app.controller.Controller;
import app.model.TheModel;
import app.view.TheView;


public class Start {

	private static Controller controller;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				controller = new Controller(new TheModel(), new TheView());
				controller.initController();
			}
		});
	}

}
