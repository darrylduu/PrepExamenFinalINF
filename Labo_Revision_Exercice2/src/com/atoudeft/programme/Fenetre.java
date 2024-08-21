package com.atoudeft.programme;


import com.atoudeft.controleur.EcouteurAction;
import com.atoudeft.modele.PlanDeJeu;
import com.atoudeft.vue.Panneau;
import com.atoudeft.vue.PanneauDeSaisie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author A. Toudeft
 * @since 2022
 * @version 1.0
 */
public class Fenetre extends JFrame {
	private PanneauDeSaisie panneauDeSaisie;
	private Panneau panneau;

	private PlanDeJeu planDeJeu;

	private EcouteurAction ecouteurAction;

	private JButton bAjouter, bEffacer;

	public Fenetre() {
		initialiserComposants();
		configurerFenetrePrincipale();
	}
	private void configurerFenetrePrincipale() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initialiserComposants() {
		planDeJeu = new PlanDeJeu();

		panneauDeSaisie = new PanneauDeSaisie();
		panneau = new Panneau(planDeJeu);

		panneau.setBackground(Color.WHITE);

		bAjouter = new JButton("Ajouter");
		bEffacer = new JButton("Effacer");

		JPanel pNord = new JPanel();
		pNord.add(panneauDeSaisie);
		pNord.add(bAjouter);
		pNord.add(bEffacer);

		ecouteurAction = new EcouteurAction(planDeJeu, panneauDeSaisie);

		bAjouter.addActionListener(ecouteurAction);
		bEffacer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				planDeJeu.vider();
			}
		});

		this.add(pNord, BorderLayout.NORTH);
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