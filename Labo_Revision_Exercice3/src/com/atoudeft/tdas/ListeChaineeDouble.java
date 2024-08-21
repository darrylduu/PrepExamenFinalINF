package com.atoudeft.tdas;

import java.util.NoSuchElementException;
/**
 * Impl�mente une liste d'objets de mani�re dynamique (chainage double)
 *
 * @author <a href="mailto:Abdelmoumene.Toudeft@etsmtl.ca">A. Toudeft</a>
 * @version 2005
 */
public class ListeChaineeDouble {

	private Noeud tete;
	private Noeud fin;
	private int nbElements;
	
	public ListeChaineeDouble() {
		this.tete = this.fin = null;
		this.nbElements = 0;
	}
	
	public void ajouterAuDebut(Object obj) {
		Noeud nouveau = new Noeud(tete, null, obj);
		if (tete!=null)
			tete.precedent = nouveau;
		else
			fin = nouveau;	//l'�l�ment ajout� est aussi le dernier
		tete = nouveau;
		nbElements++;
	}
	public void ajouterALaFin(Object obj) {
		Noeud nouveau = new Noeud(null, fin, obj);
		if (fin!=null)
			fin.suivant = nouveau;
		else
			tete = nouveau;	//l'�l�ment ajout� est aussi le premier
		fin = nouveau;
		nbElements++;	
	}
	/*
	 * Ajoute un �l�ment � la position index.
	 * D�clenche l'exception si index est hors limites (<0 ou >nbElements)
	 */
	public void ajouter(int index, Object obj) throws IndexOutOfBoundsException{

		if (index<0 || index>this.nbElements)
			throw new IndexOutOfBoundsException("Indice ("+index+") hors limites!");

		if (index==0) //ajouter au d�but
			this.ajouterAuDebut(obj);
		else if (index==this.nbElements) //ajouter � la fin
			this.ajouterALaFin(obj);
		else { //ajouter � une position quelconque
			Noeud temp = tete;
			int i = 1;
			while (temp.suivant != null && i<index) {
				temp = temp.suivant;
				i++;
			}
			Noeud nouveau = new Noeud(temp.suivant, temp, obj);
		    temp.suivant = nouveau;
		    if (nouveau.suivant!=null)
		    	nouveau.suivant.precedent = nouveau;
		    nbElements++;
		}		
	}
	
	/*
	 * Retourne l'�l�ment de la liste qui se trouve � la position index.
	 * D�clenche l'exception si index est hors limites (<0 ou >nbElements)
	 */
	public Object get(int index) throws IndexOutOfBoundsException{

		Noeud temp;
		int i;
		
		if (index<0 || index>=this.nbElements)
			throw new IndexOutOfBoundsException("Indice ("+index+") hors limites!");
		
		//On cherche l'�l�ment du d�but si l'�l�ment est proche du d�but et de 
		//la fin s'il est proche de la fin :
		if (index < nbElements/2) {
			temp = tete;
			i = 0;
			while (temp!=null && i<index) {
				temp = temp.suivant;
				i++;
			}
		}
		else {
			temp = fin;
			i = nbElements-1;
			while (temp!=null && i>index) {
				temp = temp.precedent;
				i--;
			}
		}
		return temp.donnee;
	}
	
	/*
	 * Retire le dernier �l�ment de la liste.
	 * D�clenche l'exception si la liste est vide
	 */
	public Object retirerDernier() throws NoSuchElementException {
		
		Object objRetire = null;
		
		if (estVide())
			throw new NoSuchElementException("Liste vide!");
		
		objRetire = this.fin.donnee;
		this.fin = this.fin.precedent;
		if (this.fin == null) //l'�l�ment retir� est le seul dans la liste
			this.tete = null;
		else
			this.fin.suivant = null;
		nbElements--;
		return objRetire;
	}
	/*
	 * Retire le premier �l�ment de la liste.
	 * D�clenche l'exception si la liste est vide
	 */
	public Object retirerPremier() throws NoSuchElementException {
		
		Object objRetire = null;
		
		if (estVide())
			throw new NoSuchElementException("Liste vide!");	
		
		objRetire = this.tete.donnee;
		this.tete = this.tete.suivant;
		if (this.tete == null) //l'�l�ment retir� est le seul dans la liste
			this.fin = null;
		else
			this.tete.precedent = null;
		nbElements--;
		return objRetire;
	}
	/*
	 * Retire l'�l�ment de la liste qui se trouve � la position index.
	 * D�clenche l'exception IndexOutOfBoundsException si index est hors limites
	 * (<0 ou >nbElements)
	 * D�clenche l'exception NoSuchElementException si la liste est vide
	 */
	public Object retirer(int index) 
			throws IndexOutOfBoundsException, NoSuchElementException {
		Object x = null;
		Noeud temp;
		int i;
		
		if (estVide())
			throw new NoSuchElementException("Liste vide!");
		
		if (index<0 || index>=this.nbElements)
			throw new IndexOutOfBoundsException("Indice ("+index+") hors limites!");
		
		if (index==0)
			x = this.retirerPremier();
		else if (index == nbElements-1)
			x = this.retirerDernier();
		else {
			//On cherche l'�l�ment � retirer : la recherche se fait du d�but
			//si l'�l�ment est proche du d�but et de la fin s'il est proche de
			//la fin :
			if (index < nbElements/2) {
				//Recherche du d�but :
				temp = tete;
				i = 0;
				while (i<index) {
					temp = temp.suivant;
					i++;
				}
			}
			else {
				//Recherche de la fin :
				temp = fin;
				i = nbElements-1;
				while (i>index) {
					temp = temp.precedent;
					i--;
				}
			}
			//retirer l'�l�ment r�f�renc�par temp :
			x = temp.donnee;
			temp.suivant.precedent = temp.precedent;
			temp.precedent.suivant = temp.suivant;
			nbElements--;
		}
		return x;
	}
	
	/*
	 * Vide la liste
	 */
	public void vider() {
		while (!estVide())
			retirerPremier(); //ou: retirerDernier();
	}

	/*
	 * Retourne la position du premier �l�ment de la liste qui est equals � obj.
	 * Retourn -1 s'il n'y en a pas. 
	 */
	public int indexOf(Object obj) {
		int indice = -1;

		int i = 0;
		Noeud temp = this.tete;
		while (temp != null && indice == -1) {
			if (temp.donnee.equals(obj))
				indice = i;
			temp = temp.suivant;
			i++;
		}		
		return indice;
	}	
	
	/*
	 * Indique si la liste est vide
	 */
	public boolean estVide() {
		return nbElements==0;
	}
	
	/*
	 * Taille de la liste
	 */
	public int taille() {
		return nbElements;
	}
	
	/*
	 * M�thode pas demand�e dans le laboratoire (utilis�e pour la d�monstration)
	 * Convertit la liste en String.
	 */
	public String toString() {
		String s = "Liste (taille:"+this.nbElements+")[";
		Noeud temp = tete;
		int i = 0;
		while (temp!=null) {
			s += i+"=>"+temp.donnee;
			if (i<nbElements-1)
				s += "; ";
			temp = temp.suivant;
			i++;
		}
		s += "]";
		return s;
	}


    /**
     * Inverse la liste : le premier devient le dernier, le second devient
     * l'avant-dernier,...
     * 
     */	
	public void inverser() {
		//� compl�ter :
		
	}
	private class Noeud {
		public Object donnee;
		public Noeud suivant;
		public Noeud precedent;
		
		public Noeud(Noeud next, Noeud previous, Object data) {
		   this.donnee = data;
		   this.suivant = next;
 		   this.precedent = previous;
		}
	}
}
