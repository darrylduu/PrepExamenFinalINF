package com.atoudeft.vue;

import java.awt.Color;
import java.awt.Graphics;

import com.atoudeft.modele.Carre;
/**
 * @author A. Toudeft
 * @since 2022
 * @version 1.0
 */
public class OutilDeDessin {

	public static void dessine(Carre carre, Graphics g) {
        Color couleurCourante = g.getColor();
        g.setColor(carre.getCouleur());
        g.fillRect(carre.getPosX(), carre.getPosY(), 
        			carre.getCote(), carre.getCote());
        g.setColor(couleurCourante);
	}
}
