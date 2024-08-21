package com.atoudeft.vue;

import com.atoudeft.modele.Carre;
import com.atoudeft.modele.PlanDeJeu;
import observer.Observable;
import observer.Observateur;

import javax.swing.*;
import java.awt.*;
import java.util.ListIterator;

public class Panneau extends JPanel implements Observateur {
    private PlanDeJeu planDeJeu;

    public Panneau(PlanDeJeu planDeJeu){
        this.planDeJeu = planDeJeu;
        planDeJeu.ajouterObservateur(this);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        ListIterator<Carre> itCarre = this.planDeJeu.getCarres().listIterator();
        while(itCarre.hasNext()){
            OutilDeDessin.dessine(itCarre.next(), g);
        }
    }

    @Override
    public void seMettreAJour(Observable observable) {
        this.repaint();
    }
}
