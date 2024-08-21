public class Demo {
    public static void main(String[] args) {
        Personne p1 = new Personne("Alice", "Paris");
        Personne p2 = new Personne("Bob", "Paris");
        Personne p3 = new Personne("Alice", "Paris");

        Etudiant e1 = new Etudiant("Alice", "Paris", "UQAM", 90);
        Etudiant e2 = new Etudiant("Bob", "Paris", "UQAM", 80);
        Etudiant e3 = new Etudiant("Alice", "Paris", "UQAM", 90);

        Etablissement etab = new Etablissement("Balls");
        etab.ajouter(p1);
        etab.ajouter(p2);
        etab.ajouter(p3);
        etab.ajouter(e1);
        etab.ajouter(e2);
        etab.ajouter(e3);


        System.out.println(etab.getNbEtudiants());
        System.out.println(etab.getNbMembresParVille("Paris"));
        System.out.println(etab.getMoyenneEtudiants());
    }
}
