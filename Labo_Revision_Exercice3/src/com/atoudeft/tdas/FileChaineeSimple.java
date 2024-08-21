package com.atoudeft.tdas;

/**
 * Implémente une file d'objets de manière dynamique (chainage simple)
 * Stratégie de fonctionnement : FIFO (First In First Out).
 *
 * @author <a href="mailto:Abdelmoumene.Toudeft@etsmtl.ca">A. Toudeft</a>
 * @version 2005
 */
public class FileChaineeSimple{

	 private Noeud premier; 		//référence le premier élément de la file
	 private Noeud dernier; 		//référence le dernier élément de la file
	 
	 private int nbElement; 	//Nombre d'éléments dans la file (utilisé pour
	 					//ne pas avoir à recalculer le nombre d'éléments dans 
	 					//la méthode taille()). Ne pas oublier de l'incrémenter
	 					//lorsqu'on ajoute et le décrémenter lorsqu'on retire.

    /**
     * Constructeur sans paramètre
     * Initialise les références premier et dernier à null et nbElement à 0.
     */
    public FileChaineeSimple(){
    	this.premier = this.dernier = null;
    	this.nbElement = 0;
    }

    /**
     * Crée une file de la même façon que le premier constructeur.
     * Ce constructeur est laissé là juste pour que les programmes déjà écrits
     * avec le version statique de la file continuent de fonctionner.
     * @param taille La taille voulue pour la file.
     * 
     */
    public FileChaineeSimple(int taille){
    	this.premier = this.dernier = null;
    	this.nbElement = 0;
    }

    /**
     * Ajoute un élément à la fin de la file.
     * 
     * @param element l'élément à enfiler.
     * @return true si l'opération réussit et false sinon (ce qui n'arrive jamais)
     */
    public boolean enfiler(Object element) {
    	Noeud nouveau = new Noeud(null, element);
    	if (estVide())
    		this.premier = nouveau; //l'élément ajouté est aussi le premier
    	else
    		this.dernier.suivant = nouveau;
    	this.dernier = nouveau; //l'élément ajouté devient le nouveau dernier
    	this.nbElement++;
    	return true;
    }

    /**
     * Retire le premier élément de la file.
     * 
     * @return Le premier élément de la file s'il existe ou null sinon.
     */
    public Object defiler(){
    	if (estVide())
    		return null;
    	Object objRetire = this.premier.donnee;
    	this.premier = this.premier.suivant;
    	if (this.premier==null) //l'élément retiré était le dernier
    		this.dernier = null;
    	this.nbElement--;
    	return objRetire;
    }

    /**
     * Indique si la file est vide.
     * 
     * @return true si la  file est vide et false sinon.
     */
    public boolean estVide(){
       
    	return nbElement == 0;
    }

	 /**
	  * Vide la file.
	  */
	 public void vider(){
		 while (!estVide())
			 defiler();		 
	 }

    /**
     * Permet de consulter le premier élément de la file sans l'enlever.
     * 
     * @return Le premier élément si la file n'est pas vide et null sinon.
     */
    public Object debut(){
    	if (estVide())
    		return null;
    	return this.premier.donnee;
    }

    /**
     * Retourne le nombre d'éléments dans la file.
     * 
     * @return Le nombre d'éléments actuellement dans la file.
     */
    public int taille(){
    	
    	return nbElement;
    }
    
    /**
     * Inverse la file : le premier devient le dernier, le second devient
     * l'avant-dernier,...
     * 
     */	
    public void inverser() {
		if(this.taille() <= 1){
			return;
		}
		Noeud previous = null;
		Noeud current = this.premier;
		Noeud next = null;

		this.dernier = this.premier;
		while(current != null){
			next = current.suivant;
			current.suivant = previous;
			previous = current;
			current = next;
		}

		this.premier = previous;
	}
	
    private class Noeud {
    	public Object donnee;
		public Noeud suivant;
		
		public Noeud(Noeud next, Object data) {
		   this.donnee = data;
		   this.suivant = next;
		}
	}
}
