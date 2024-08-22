package vue;

import javax.swing.*;

//Classe � compl�ter.

import modele.Equation1Degre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public	class Equation1DegreUI extends JPanel implements ActionListener {
    private Equation1Degre equation;

    private JLabel lEquation = new JLabel("a.X + b = 0");
    private JLabel lA = new JLabel("a: ");
    private JLabel lB = new JLabel("b: ");
    private JLabel lSolution = new JLabel("Aucun Solution!");

    private JTextField tA = new JTextField(5);
    private JTextField tB = new JTextField(5);

    private JButton bCalculer = new JButton("Calculer");

    public Equation1DegreUI(Equation1Degre eq)
    {
        equation = eq;

        if(equation != null){
            tA.setText(String.valueOf(equation.getA()));
            tB.setText(String.valueOf(equation.getB()));
        }

        this.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(new GridLayout(2,1));
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        p1.add(lEquation, BorderLayout.CENTER);

        JPanel p2a = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel p2b = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        p2a.add(lA);
        p2a.add(tA);
        p2b.add(lB);
        p2b.add(tB);

        p2.add(p2a);
        p2.add(p2b);

        p3.add(bCalculer);
        bCalculer.addActionListener(this);

        p4.add(lSolution, BorderLayout.CENTER);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.WEST);
        this.add(p3, BorderLayout.EAST);
        this.add(p4, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bCalculer){
            if(equation != null){
                equation.setA(Double.parseDouble(tA.getText()));
                equation.setB(Double.parseDouble(tB.getText()));
                equation.resoudre();

                int nbSol = equation.getNbSol();

                if(nbSol == Equation1Degre.ZERO_SOLUTIONS){
                    lSolution.setText("Zero Solution.");
                }else if(nbSol == Equation1Degre.UNE_SOLUTIONS){
                    lSolution.setText("1 Solution x = " + equation.getX());
                }else if(nbSol == Equation1Degre.INFINITE_SOLUTIONS){
                    lSolution.setText("Infinie Solution");
                }
            }else{
                lSolution.setText("Erreur!");
            }
        }
    }
}
