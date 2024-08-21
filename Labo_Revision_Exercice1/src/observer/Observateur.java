package observer;

public interface Observateur {
	//Permet � l'observateur de se mettre � jour lorsqu'il est notifi� par
	//l'objet Observable qu'il observe :
	public void seMettreAJour(Observable observable);
}
