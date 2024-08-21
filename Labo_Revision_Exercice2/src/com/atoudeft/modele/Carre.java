/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.modele;

import java.awt.Color;

import observer.Observable;

/**
 * @author A. Toudeft
 * @since 2022
 * @version 1.0
 */
public class Carre extends Observable {
    private int cote = 50;
    private int posX, posY;
    private Color couleur = Color.BLACK;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        this.notifierObservateurs();
    }
    public int getPosY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
        this.notifierObservateurs();
    }
    public Color getCouleur() {
        return couleur;
    }
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
        this.notifierObservateurs();
    }
    public int getCote() {
        return cote;
    }
    public void setCote(int cote) {
        this.cote = cote;
        this.notifierObservateurs();
    }
    public void moveRight() {
        this.posX++;
        this.notifierObservateurs();
    }
    public void moveLeft() {
        this.posX--;
        this.notifierObservateurs();
    }
    public void moveDown() {
        this.posY++;
        this.notifierObservateurs();
    }
    public void moveUp() {
        this.posY--;
        this.notifierObservateurs();
    }
}