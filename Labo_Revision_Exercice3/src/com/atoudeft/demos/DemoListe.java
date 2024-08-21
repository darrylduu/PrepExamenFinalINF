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
					System.out.println("Ajouter un �l�ment au d�but :");
					System.out.print("Valeur � ajouter : ");
					valeur = clavier.nextInt();
					clavier.nextLine();
					liste.ajouterAuDebut(valeur);
					break;
				case 'f':
					System.out.println("Ajouter un �l�ment � la fin :");
					System.out.print("Valeur � ajouter : ");
					valeur = clavier.nextInt();
					clavier.nextLine();
					liste.ajouterALaFin(valeur);
					break;
				case '+':
					System.out.println("Ajouter un �l�ment :");
					System.out.print("Valeur � ajouter : ");
					valeur = clavier.nextInt();
					System.out.print("Position : ");
					index = clavier.nextInt();
					clavier.nextLine();
					liste.ajouter(index, valeur);
					break;
				case 'c':
					System.out.print("Position de l'�l�ment � consulter : ");
					index = clavier.nextInt();
					clavier.nextLine();
					valeur = (int)liste.get(index);
					System.out.println("�l�ment � la position "+ index 
													   + " : " + valeur);
					break;					
				case 'r':
					System.out.print("Position de l'�l�ment � retirer : ");
					index = clavier.nextInt();
					clavier.nextLine();
					valeur = (int)liste.retirer(index);
					System.out.println("�l�ment retir� : " + valeur);
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

			//On r�affiche le menu :
			choix=menu();
		}
		System.out.println("Bye Bye");
	}

	private static char menu() {
		char reponse;
		String str;
		System.out.println("\n------- MENU -------\n\n"
				+ "a. Afficher liste.\n"
				+ "d. Ajouter un �l�ment au d�but.\n"
				+ "f. Ajouter un �l�ment � la fin.\n"
				+ "+. Ajouter une �l�ment � une position quelconque.\n"
				+ "c. Consulter un �l�ment.\n"
				+ "r. Rechercher un �l�ment.\n"
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
