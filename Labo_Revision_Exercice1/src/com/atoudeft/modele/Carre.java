/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.modele;

import java.awt.Color;

/**
 * @author A. Toudeft
 * @since 2015
 * @version 1.0
 */
public class Carre {
    private int cote = 50;
    private int posX, posY;
    private Color couleur = Color.RED;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }
    public void moveRight() {
        this.posX++;
    }
    public void moveLeft() {
        this.posX--;
    }
    public void moveDown() {
        this.posY++;
    }
    public void moveUp() {
        this.posY--;
    }
}
