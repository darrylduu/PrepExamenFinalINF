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
        double somme = 0;
        int n = 0;
//        Personne p;
//        ListIterator<Personne> it = membres.listIterator();
//        while (it.hasNext()) {
//            p = it.next();
//            if (p instanceof Etudiant) {
//                somme += ((Etudiant) p).getNote();
//                n++;
//            }
//        }
        for(Personne p : membres){
            if (p instanceof Etudiant){
                somme += ((Etudiant) p).getNote();
                n++;
            }
        }
        if (n == 0)
            throw new IllegalStateException("Aucun étudiant");
        return somme/n;
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
