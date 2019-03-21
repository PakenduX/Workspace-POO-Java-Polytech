package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

/**
 * 3. Mouvement de Souris
 */
public class MouvementSouris extends JFrame {

    private JPanel panel;

    public MouvementSouris(){
        setTitle("Mouvement de souris");
        setBounds(30, 30, 700, 700);
        panel = new JPanel();
        add(panel);

        addMouseMotionListener(new SourisMovement());
    }

    class SourisMovement implements MouseMotionListener{

        public void mouseDragged(MouseEvent e){}

        public void mouseMoved(MouseEvent e) {
            //On récupère le contexte graphique.
            Graphics g = panel.getGraphics();
            Graphics2D g2 = (Graphics2D)g;
            //À la demande du prof, on dessine plutôt des rectangles 2x2 pour
            //plus de visibilité.
            g2.draw(new Rectangle2D.Double(e.getX(), e.getY(), 2, 2));
            g2.dispose();
        }
    }
}
