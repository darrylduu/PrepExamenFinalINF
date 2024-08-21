public class Cours {
    private String sigle;
    private int duree; //en heures/semaine

    public Cours(String sigle, int duree) {
        this.sigle = sigle;
        this.duree = duree;
    }

    public String getSigle() {
        return sigle;
    }
    public int getDuree() {
        return duree;
    }
}
