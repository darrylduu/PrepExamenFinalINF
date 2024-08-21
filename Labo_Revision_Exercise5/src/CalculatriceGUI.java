import javax.swing.*;
import java.awt.*;

public class CalculatriceGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(385, 300);
        frame.setLayout(new BorderLayout());

        JPanel p1Nord = new JPanel(new BorderLayout());
        JPanel p1Centre = new JPanel(new BorderLayout());

        JPanel p2BackCEC = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel p2Chiffres = new JPanel(new GridLayout(4,5, 5,10));
        JPanel p2Ouest = new JPanel(new GridLayout(0, 1, 0,10 ));

        JTextField numTField = new JTextField();
        numTField.setPreferredSize(new Dimension(385, 20));
        numTField.setHorizontalAlignment(JTextField.RIGHT);

        p1Nord.add(numTField);

        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(65, 30));
        back.setForeground(new Color(153, 0, 0));
        p2BackCEC.add(back);

        JButton ce = new JButton("CE");
        ce.setPreferredSize(new Dimension(55, 30));
        ce.setForeground(new Color(153, 0, 0));
        p2BackCEC.add(ce);

        JButton c = new JButton("C");
        c.setPreferredSize(new Dimension(45, 30));
        c.setForeground(new Color(153, 0, 0));
        p2BackCEC.add(c);

        JButton mc = new JButton("MC");
        mc.setForeground(Color.RED);
        p2Ouest.add(mc);

        JButton mr = new JButton("MR");
        mr.setForeground(Color.RED);
        p2Ouest.add(mr);

        JButton ms = new JButton("MS");
        ms.setForeground(Color.RED);
        p2Ouest.add(ms);

        JButton mplus = new JButton("M+");
        mplus.setForeground(Color.RED);
        p2Ouest.add(mplus);

        JButton b7 = new JButton("7");
        b7.setForeground(Color.BLUE);
        p2Chiffres.add(b7);

        JButton b8 = new JButton("8");
        b8.setForeground(Color.BLUE);
        p2Chiffres.add(b8);

        JButton b9 = new JButton("9");
        b9.setForeground(Color.BLUE);
        p2Chiffres.add(b9);

        JButton bSlash = new JButton("/");
        bSlash.setForeground(Color.BLUE);
        p2Chiffres.add(bSlash);

        JButton bsqrt = new JButton("sqrt");
        bsqrt.setForeground(Color.BLUE);
        p2Chiffres.add(bsqrt);

        JButton b4 = new JButton("4");
        b4.setForeground(Color.BLUE);
        p2Chiffres.add(b4);

        JButton b5 = new JButton("5");
        b5.setForeground(Color.BLUE);
        p2Chiffres.add(b5);

        JButton b6 = new JButton("6");
        b6.setForeground(Color.BLUE);
        p2Chiffres.add(b6);

        JButton bm = new JButton("*");
        bm.setForeground(Color.BLUE);
        p2Chiffres.add(bm);

        JButton bd = new JButton("%");
        bd.setForeground(Color.BLUE);
        p2Chiffres.add(bd);

        JButton b1 = new JButton("1");
        b1.setForeground(Color.BLUE);
        p2Chiffres.add(b1);

        JButton b2 = new JButton("2");
        b2.setForeground(Color.BLUE);
        p2Chiffres.add(b2);

        JButton b3 = new JButton("3");
        b3.setForeground(Color.BLUE);
        p2Chiffres.add(b3);

        JButton bmin = new JButton("-");
        bmin.setForeground(Color.BLUE);
        p2Chiffres.add(bmin);

        JButton b1x = new JButton("1/x");
        b1x.setForeground(Color.BLUE);
        p2Chiffres.add(b1x);

        JButton b0 = new JButton("0");
        b0.setForeground(Color.BLUE);
        p2Chiffres.add(b0);

        JButton bpm = new JButton("±");
        bpm.setForeground(Color.BLUE);
        p2Chiffres.add(bpm);

        JButton bp = new JButton(".");
        bp.setForeground(Color.BLUE);
        p2Chiffres.add(bp);

        JButton bplus = new JButton("+");
        bplus.setForeground(Color.BLUE);
        p2Chiffres.add(bplus);

        JButton be = new JButton("=");
        be.setForeground(Color.BLUE);
        p2Chiffres.add(be);

        p1Nord.add(p2BackCEC, BorderLayout.SOUTH);
        p1Centre.add(p2Chiffres, BorderLayout.EAST);
        p1Centre.add(p2Ouest, BorderLayout.WEST);

        frame.add(p1Nord, BorderLayout.NORTH);
        frame.add(p1Centre, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
