package tp4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * La fenêtre contenant les menus de dessin
 * @author DEMBELE Mama
 */
public class DessinFormeWindow extends JFrame {

    private DessinForme df;

    private final int P_WIDTH = 200;
    private final int P_HEIGHT = 200;
    private final int G_WIDTH = 300;
    private final int G_HEIGHT = 300;

    //Ceux-ci sont mis en attributs pour avoir accès dans la
    //classe interne.
    JMenuItem cercle;
    JMenuItem rect;
    JMenuItem petit;
    JMenuItem grand;
    JMenuItem bleu;
    JMenuItem rouge;

    public DessinFormeWindow(){
        setTitle("Dessin de formes par des listes déroulants");
        setSize(700, 500);
        setLocationRelativeTo(null);

        df = new DessinForme();

        JMenuBar maBarre = new JMenuBar();

        JMenu forme_type = new JMenu("Type de forme");
        JMenu forme_color = new JMenu("Couleur de la forme");
        JMenu forme_dim = new JMenu("Dimension de la forme");

        cercle = new JMenuItem("Cercle");
        rect = new JMenuItem("Rectangle");
        petit = new JMenuItem("Petit");
        grand = new JMenuItem("Grand");
        bleu = new JMenuItem("Bleu");
        rouge = new JMenuItem("Rouge");

        forme_type.add(cercle);
        forme_type.add(rect);
        forme_color.add(bleu);
        forme_color.add(rouge);
        forme_dim.add(petit);
        forme_dim.add(grand);

        maBarre.add(forme_type);
        maBarre.add(forme_dim);
        maBarre.add(forme_color);

        setJMenuBar(maBarre);

        cercle.addActionListener(new ChoixMenu());
        rect.addActionListener(new ChoixMenu());
        petit.addActionListener(new ChoixMenu());
        grand.addActionListener(new ChoixMenu());
        bleu.addActionListener(new ChoixMenu());
        rouge.addActionListener(new ChoixMenu());

        add(df);


    }

    class ChoixMenu implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == cercle)
                df.setForme_type(new Ellipse2D.Double());
            else if(e.getSource() == rect)
                df.setForme_type(new Rectangle2D.Double());
            else if(e.getSource() == petit)
                df.setForme_dim(new Dimension(P_WIDTH, P_HEIGHT));
            else if(e.getSource() == grand)
                df.setForme_dim(new Dimension(G_WIDTH, G_HEIGHT));
            else if(e.getSource() == bleu)
                df.setForme_color(Color.BLUE);
            else if(e.getSource() == rouge)
                df.setForme_color(Color.RED);

            df.repaint();
        }
    }

    public static void main(String[] args){
        DessinFormeWindow dfw = new DessinFormeWindow();
        dfw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dfw.setVisible(true);
    }
}
