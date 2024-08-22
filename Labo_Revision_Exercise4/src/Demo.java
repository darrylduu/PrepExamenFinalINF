public class Demo {
    public static void main(String[] args) {
        // Case 1: No students in the Etablissement
        Etablissement etab1 = new Etablissement("Etab1");
        etab1.ajouter(new Personne("Alice", "Paris"));
        etab1.ajouter(new Personne("Bob", "Paris"));
        System.out.println("Case 1: No students");
        System.out.println("Number of students: " + etab1.getNbEtudiants());
        System.out.println("Number of members in Paris: " + etab1.getNbMembresParVille("Paris"));
        try {
            System.out.println("Average student grade: " + etab1.getMoyenneEtudiants());
        } catch (IllegalStateException e) {
            System.out.println("Average student grade: " + e.getMessage());
        }

        // Case 2: Some students in the Etablissement
        Etablissement etab2 = new Etablissement("Etab2");
        etab2.ajouter(new Personne("Alice", "Paris"));
        etab2.ajouter(new Etudiant("Bob", "Paris", "UQAM", 80));
        System.out.println("\nCase 2: Some students");
        System.out.println("Number of students: " + etab2.getNbEtudiants());
        System.out.println("Number of members in Paris: " + etab2.getNbMembresParVille("Paris"));
        System.out.println("Average student grade: " + etab2.getMoyenneEtudiants());

        // Case 3: All students in the Etablissement
        Etablissement etab3 = new Etablissement("Etab3");
        etab3.ajouter(new Etudiant("Alice", "Paris", "UQAM", 90));
        etab3.ajouter(new Etudiant("Bob", "Paris", "UQAM", 80));
        System.out.println("\nCase 3: All students");
        System.out.println("Number of students: " + etab3.getNbEtudiants());
        System.out.println("Number of members in Paris: " + etab3.getNbMembresParVille("Paris"));
        System.out.println("Average student grade: " + etab3.getMoyenneEtudiants());
    }
}