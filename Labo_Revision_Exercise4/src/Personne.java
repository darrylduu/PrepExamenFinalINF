public class Personne {
    private String nom, ville;

    public Personne(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public void demenage(String nouvelleVille) {
        this.ville = nouvelleVille;
    }

    public String getVille() {
        return this.ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Personne) {
            Personne p = (Personne) o;
            return nom.equalsIgnoreCase(p.nom);
        }

        return false;
    }
}
