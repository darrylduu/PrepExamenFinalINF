package com.atoudeft.controleur;

import com.atoudeft.modele.Carre;
import com.atoudeft.modele.PlanDeJeu;
import com.atoudeft.vue.PanneauDeSaisie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurAction implements ActionListener {
    private PlanDeJeu planDeJeu;
    private PanneauDeSaisie panneauDeSaisie;

    public EcouteurAction(PlanDeJeu planDeJeu, PanneauDeSaisie panneauDeSaisie){
        this.planDeJeu = planDeJeu;
        this.panneauDeSaisie = panneauDeSaisie;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            int posH, posV, lCote;
            String temp;
            Color couleur;

            try {
                temp = panneauDeSaisie.getPosH();
                posH = Integer.parseInt(temp);

                temp = panneauDeSaisie.getPosV();
                posV = Integer.parseInt(temp);

                temp = panneauDeSaisie.getLongCote();
                lCote = Integer.parseInt(temp);

                couleur = panneauDeSaisie.getCouleur();

                Carre carre = new Carre();
                carre.setPosY(posH);
                carre.setPosX(posV);
                carre.setCote(lCote);
                carre.setCouleur(couleur);

                planDeJeu.ajouter(carre);

            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(panneauDeSaisie,
                        "Error!");
            }
        }
    }
}
