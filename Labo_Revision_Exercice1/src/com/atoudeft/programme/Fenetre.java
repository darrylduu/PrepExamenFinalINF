package com.atoudeft.programme;

import com.atoudeft.controleur.EcouteurClavier;
import com.atoudeft.modele.Carre;
import com.atoudeft.vue.Panneau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @author A. Toudeft
 * @since 2015
 * @version 1.0
 */
public class Fenetre extends JFrame {
	private Carre carre;
	private Panneau panneau;
	private EcouteurClavier ecouteurClavier;

	public Fenetre() {
		initialiserComposants();
		configurerFenetrePrincipale();
	}
	private void configurerFenetrePrincipale() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initialiserComposants() {
		carre = new Carre();

		panneau = new Panneau(carre);
		panneau.setBackground(Color.WHITE);

		ecouteurClavier = new EcouteurClavier(carre, panneau);

		this.addKeyListener(ecouteurClavier);
		this.add(panneau, BorderLayout.CENTER);
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