package com.atoudeft.controleur;

import com.atoudeft.modele.Carre;
import com.atoudeft.vue.Panneau;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteurClavier implements KeyListener {
    private Carre carre;
    private Panneau panneau;

    public EcouteurClavier(Carre carre, Panneau panneau) {
        this.carre = carre;
        this.panneau = panneau;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        switch (keycode){
            case Touche.FLECHE_DROITE:
                if(carre.getPosX() + carre.getCote() < panneau.getWidth())
                    carre.moveRight();
                break;
            case Touche.FLECHE_GAUCHE:
                if(carre.getPosX() > 0)
                    carre.moveLeft();
                break;
            case Touche.FLECHE_HAUT:
                if(carre.getPosY() > 0)
                    carre.moveUp();
                break;
            case Touche.FLECHE_BAS:
                if(carre.getPosY() + carre.getCote() < panneau.getHeight()){
                    carre.moveDown();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
