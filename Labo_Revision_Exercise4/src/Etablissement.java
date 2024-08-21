import java.util.ArrayList;
import java.util.ListIterator;

public class Etablissement {
    private String nom;
    private ArrayList<Personne> membres;

    public Etablissement(String nom) {
        this.nom = nom;
        membres = new ArrayList<>();
    }

    public boolean ajouter(Personne personne) {
        if (membres.contains(personne)) {
            return false;
        }
        if (membres.size() >= Config.MAX_MEMBRES) {
            return false;
        }

        membres.add(personne);

        return true;
    }

    public int getNbEtudiants() {
        int nbEtudiant = 0;

        for (int i = 0; i < membres.size(); i++) {
            if (membres.get(i) instanceof Etudiant) {
                nbEtudiant++;
            }
        }

        return nbEtudiant;
    }

    public int getNbMembresParVille(String ville) {
        int nbMembres = 0;

        Personne p;

        for (int i = 0; i < membres.size(); i++) {
            p = membres.get(i);
            if (p.getVille().equals(ville)) {
                nbMembres++;
            }
        }
        return nbMembres;
    }

    public double getMoyenneEtudiants() {
        double note = 0;
        int nbEtudiant = 0;
        Personne p;

        ListIterator<Personne> itPersonne = membres.listIterator();
        while(itPersonne.hasNext()) {
            p = itPersonne.next();
            if(p instanceof Etudiant) {
                note += ((Etudiant) p).getNote();
                nbEtudiant++;
            }
        }
        if (membres.size() == 0) { //Ou: if (membres.isEmpty()) {
            throw new IllegalStateException("Aucun étudiant");
        }

        return note / nbEtudiant;
    }

    public void toutLeMondeDemenageALaval() {
        Personne p;

        ListIterator<Personne> itPersonne = membres.listIterator();
        while(itPersonne.hasNext()) {
            p = itPersonne.next();
            if(p instanceof Etudiant){
                ((Etudiant) p).demenage("Laval");
            }else {
                p.demenage("Laval");
            }
        }
    }
}
