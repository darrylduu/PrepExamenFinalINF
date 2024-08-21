package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanneauDeSaisie extends JPanel {
    private JTextField tPosH, tPosV, tLongCote;
    private JButton bCouleur;

    public PanneauDeSaisie() {
        super();
        JLabel lPosH = new JLabel("Position Horizontale: ");
        JLabel lPosV = new JLabel("Position Verticale: ");
        JLabel lLongCote = new JLabel("Longeur du cote: ");

        tPosH = new JTextField(10);
        tPosV = new JTextField(10);
        tLongCote = new JTextField(10);

        bCouleur = new JButton("Couleur");
        bCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();

                Color couleur = JColorChooser.showDialog(PanneauDeSaisie.this,
                        "Choisir Couleur", source.getBackground());

                if (couleur != null) {
                    source.setBackground(couleur);
                }
            }
        });

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        p1.add(lPosH);
        p1.add(tPosH);

        p2.add(lPosV);
        p2.add(tPosV);

        p3.add(lLongCote);
        p3.add(tLongCote);

        p4.add(bCouleur);

        this.setLayout(new GridLayout(4, 1));
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
    }

    public String getPosH() {
        return tPosH.getText();
    }

    public String getPosV() {
        return tPosV.getText();
    }

    public String getLongCote() {
        return tLongCote.getText();
    }

    public Color getCouleur() {
        return bCouleur.getBackground();
    }
}
