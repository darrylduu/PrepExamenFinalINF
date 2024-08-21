package com.atoudeft.vue;

import com.atoudeft.modele.Carre;
import observer.Observable;
import observer.Observateur;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel implements Observateur {
    private Carre carre;

    public Panneau(Carre carre){
        this.carre = carre;
        carre.ajouterObservateur(this);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        OutilDeDessin.dessine(carre, g);
    }

    @Override
    public void seMettreAJour(Observable observable) {
        this.repaint();
    }
}
