package com.atoudeft.demos;

import com.atoudeft.tdas.FileChaineeSimple;

public class DemoFile {

	public static void main(String[] args) {
		
		FileChaineeSimple file = new FileChaineeSimple();
		String valeur;
		
		//On enfile 4 �l�ments :
		file.enfiler("Suzie");
		file.enfiler("Salim");
		file.enfiler("Pierre");
		file.enfiler("Georges");
		
		//On inverse la file :
		file.inverser();

		//Retirer tous les �l�ments de file en les affichant ainsi que la taille
		//de la file :
		while (!file.estVide()) {
			valeur = (String)file.defiler();
			System.out.println("�l�ment d�pil� : "+valeur
							+"; Taille de la file "+file.taille());
		}
	}
}
