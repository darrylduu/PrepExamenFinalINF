package com.atoudeft.programme;


import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @author A. Toudeft
 * @since 2022
 * @version 1.0
 */
public class Fenetre extends JFrame {

	//à compléter :

	public Fenetre() {
		initialiserComposants();
		configurerFenetrePrincipale();
	}
	private void configurerFenetrePrincipale() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initialiserComposants() {

		//à compléter :
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Fenetre().setVisible(true);
			} 
		});
	}
}