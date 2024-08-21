public class Etudiant extends Personne{
    private String etablissement;
    private double note;
    private Cours[] coursSuivis;
    private int nbCours;

    public Etudiant(String nom, String ville, String etablis, double note) {
        super(nom, ville);
        this.etablissement = etablis;
        this.note = note;
        coursSuivis = new Cours[8];
        nbCours = 0;
    }

    public double getNote() {
        return note;
    }

    @Override
    public void demenage(String nouvelleEtablissement) {
        this.etablissement = nouvelleEtablissement;
    }

    public void setVille(String nouvelleVille) {
        super.demenage(nouvelleVille);
    }

    public int getNbHeuresParSemaine() {
        int nbHeures = 0;

        for (int i = 0; i < nbCours; i++) {
            nbHeures += coursSuivis[i].getDuree();
        }

        return nbHeures;
    }

    public boolean ajouter(Cours cours) {
        if(nbCours >= coursSuivis.length){
            return false;
        }
        if(cours.getDuree() + getNbHeuresParSemaine() > Config.MAX_HEURES_ETUDES){
            return false;
        }
        for (int i = 0; i < nbCours; i++) {
            if (cours.getSigle().equals(coursSuivis[i].getSigle())){
                return false;
            }
        }
        coursSuivis[nbCours] = cours;
        nbCours++;

        return true;
    }
}
