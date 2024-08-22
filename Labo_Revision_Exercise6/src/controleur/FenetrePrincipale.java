package controleur;

import javax.swing.JFrame;

import modele.Equation1Degre;
import vue.Equation1DegreUI;

public class FenetrePrincipale extends JFrame {
    private Equation1Degre e;
    private Equation1DegreUI eui;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new FenetrePrincipale()).setVisible(true);
            }
        });
    }

    public FenetrePrincipale()
    {
        initialiserComposants();
        configurerFenetrePrincipale();
    }

    private void configurerFenetrePrincipale() {
        setSize(240,160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void initialiserComposants()
    {
        e = new Equation1Degre(3,-12);
        eui = new Equation1DegreUI(e);
        this.add(eui);
    }
}
