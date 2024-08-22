import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fenetrePrincipale extends JFrame implements ActionListener, Runnable {
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 150;

    private JTextField tSaisie;
    private JLabel lSaisie;

    public fenetrePrincipale(){
        setTitle("Saisie de donnees");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - FRAME_WIDTH) / 2;
        int y = (screenSize.height - FRAME_HEIGHT) / 2;
        setLocation(x, y);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        setContentPane(mainPanel);

        tSaisie = new JTextField(20);
        JButton bValider = new JButton("Valider");
        lSaisie = new JLabel();
        lSaisie.setForeground(Color.WHITE);

        this.add(tSaisie);
        this.add(bValider);
        this.add(lSaisie);

        bValider.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = tSaisie.getText();
        lSaisie.setText(text);
        tSaisie.setText("");
    }

    @Override
    public void run() {
        setVisible(true);
    }

    public static void main(String[] args) {
        fenetrePrincipale fenetrePrincipale = new fenetrePrincipale();
        Thread thread = new Thread(fenetrePrincipale);
        thread.run();
    }
}
