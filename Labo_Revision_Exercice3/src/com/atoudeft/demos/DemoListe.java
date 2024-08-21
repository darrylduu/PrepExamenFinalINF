package com.atoudeft.demos;

import java.util.Locale;
import java.util.Scanner;

import com.atoudeft.tdas.ListeChaineeDouble;

public class DemoListe {

	public static Scanner clavier = new Scanner(System.in);
	public static final char QUITTER = 'q';

	public static void main(String[] args) {
		char choix;
		int index;
		ListeChaineeDouble liste = new ListeChaineeDouble();
		int valeur;

		clavier.useLocale(Locale.ENGLISH);

		choix=menu();
		while (choix!=QUITTER)
		{
			try {				
				switch (choix)
				{
				case 'a':
					System.out.println(liste);
					break;
				case 'i':
					//On inverse la liste :
					liste.inverser();
					break;
				case 'd':
					System.out.println("Ajouter un élément au début :");
					System.out.print("Valeur à ajouter : ");
					valeur = clavier.nextInt();
					clavier.nextLine();
					liste.ajouterAuDebut(valeur);
					break;
				case 'f':
					System.out.println("Ajouter un élément à la fin :");
					System.out.print("Valeur à ajouter : ");
					valeur = clavier.nextInt();
					clavier.nextLine();
					liste.ajouterALaFin(valeur);
					break;
				case '+':
					System.out.println("Ajouter un élément :");
					System.out.print("Valeur à ajouter : ");
					valeur = clavier.nextInt();
					System.out.print("Position : ");
					index = clavier.nextInt();
					clavier.nextLine();
					liste.ajouter(index, valeur);
					break;
				case 'c':
					System.out.print("Position de l'élément à consulter : ");
					index = clavier.nextInt();
					clavier.nextLine();
					valeur = (int)liste.get(index);
					System.out.println("Élément à la position "+ index 
													   + " : " + valeur);
					break;					
				case 'r':
					System.out.print("Position de l'élément à retirer : ");
					index = clavier.nextInt();
					clavier.nextLine();
					valeur = (int)liste.retirer(index);
					System.out.println("Élément retiré : " + valeur);
					break;
				case 'v':
					liste.vider();
					break;
				default:
					System.out.println("Option inconnue...");
				}
			}
			catch (Exception exp) {
				System.out.println("Exception : "+exp.getMessage());
			}

			//On réaffiche le menu :
			choix=menu();
		}
		System.out.println("Bye Bye");
	}

	private static char menu() {
		char reponse;
		String str;
		System.out.println("\n------- MENU -------\n\n"
				+ "a. Afficher liste.\n"
				+ "d. Ajouter un élément au début.\n"
				+ "f. Ajouter un élément à la fin.\n"
				+ "+. Ajouter une élément à une position quelconque.\n"
				+ "c. Consulter un élément.\n"
				+ "r. Rechercher un élément.\n"
				+ "v. Vider la liste.\n"
				+ "i. Inverser la liste.\n"
				+ "q. Quitter.\n");
		System.out.print("\tVotre choix : ");
		str = clavier.nextLine();
		if (str.length()>0)
			reponse = str.charAt(0);
		else
			reponse = ' ';
		return reponse;
	}

}
