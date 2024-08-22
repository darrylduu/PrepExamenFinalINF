public class DoublyLinkedList {

    class Noeud {
        int donnee;
        Noeud precedent;
        Noeud suivant;

        Noeud(int donnee) {
            this.donnee = donnee;
            this.precedent = null;
            this.suivant = null;
        }
    }

    private Noeud premier;

    public DoublyLinkedList() {
        this.premier = null;
    }

    public void insererAuDebut(int donnee) {
        Noeud nouveauNoeud = new Noeud(donnee);
        if (premier != null) {
            premier.precedent = nouveauNoeud;
            nouveauNoeud.suivant = premier;
        }
        premier = nouveauNoeud;
    }

    public void insererALaFin(int donnee) {
        Noeud nouveauNoeud = new Noeud(donnee);
        if (premier == null) {
            premier = nouveauNoeud;
            return;
        }

        Noeud temp = premier;
        while (temp.suivant != null) {
            temp = temp.suivant;
        }
        temp.suivant = nouveauNoeud;
        nouveauNoeud.precedent = temp;
    }

    public void insererALaPosition(int donnee, int position) {
        if (position < 1) {
            System.out.println("Position invalide!");
            return;
        }

        Noeud nouveauNoeud = new Noeud(donnee);

        if (position == 1) {
            insererAuDebut(donnee);
            return;
        }

        Noeud temp = premier;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position hors des limites!");
                return;
            }
            temp = temp.suivant;
        }

        if (temp == null || temp.suivant == null) {
            insererALaFin(donnee);
        } else {
            nouveauNoeud.suivant = temp.suivant;
            temp.suivant.precedent = nouveauNoeud;
            temp.suivant = nouveauNoeud;
            nouveauNoeud.precedent = temp;
        }
    }

    public void imprimerListe() {
        Noeud temp = premier;
        while (temp != null) {
            System.out.print(temp.donnee + " ");
            temp = temp.suivant;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList liste = new DoublyLinkedList();

        liste.insererAuDebut(10);
        liste.insererALaFin(20);
        liste.insererALaPosition(15, 2);
        liste.insererALaPosition(5, 1);
        liste.insererALaPosition(25, 5);

        liste.imprimerListe(); // Résultat attendu : 5 10 15 20 25
    }
}
