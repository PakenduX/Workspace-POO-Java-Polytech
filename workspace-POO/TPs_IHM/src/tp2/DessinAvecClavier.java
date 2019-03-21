package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 4. Dessin avec le clavier
 */
public class DessinAvecClavier extends JPanel {

    //On stocke les dessins dans une collection pour
    //les dessiner après successivement.
    private ArrayList<Line2D> listComponent;
    private double offset = 10;

    public DessinAvecClavier(){
        listComponent = new ArrayList<>();
        //J'initialise ma liste avec un point.
        listComponent.add(new Line2D.Double(new Point2D.Double(10, 10), new Point2D.Double(10, 10)));
        this.addKeyListener(new DirectionListener());
    }

    public void paintComponent(Graphics g){
        //On parcourt la liste des composants pour les dessiner
        //les uns après les autres.
        Iterator<Line2D> it = listComponent.iterator();
        Graphics2D g2 = (Graphics2D)g;
        while (it.hasNext())
            g2.draw(it.next());
    }

    class DirectionListener implements KeyListener{

        public void keyTyped(KeyEvent e) {

            double x = listComponent.get(listComponent.size() - 1).getX2();
            double y = listComponent.get(listComponent.size() - 1).getY2();

            char key = e.getKeyChar();

            if(key == 'h')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x - offset, y)));
            else if(key == 'l')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x + offset, y)));
            else if(key == 'j')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x, y + offset)));
            else if(key == 'k')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x, y - offset)));
            else if(key == 'H')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x - (offset*5), y)));
            else if(key == 'L')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x + (offset*5), y)));
            else if(key == 'J')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x, y + (offset*5))));
            else if(key == 'K')
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x, y - (offset*5))));

            repaint();

        }

        public void keyPressed(KeyEvent e) {
            // On récupère les coordonnées de l'extrémité droite de la dernière ligne dessinée.
           double x = listComponent.get(listComponent.size() - 1).getX2();
           double y = listComponent.get(listComponent.size() - 1).getY2();

           int code = e.getKeyCode();

           // Si la touche shift est enfoncée, on multiplie le décalage par 5.
           if(e.isShiftDown())
               offset *= 5;

            if(code == KeyEvent.VK_LEFT)
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x - offset, y)));
            else if(code == KeyEvent.VK_RIGHT)
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x + offset, y)));
            else if(code == KeyEvent.VK_DOWN)
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x, y + offset)));
            else if(code == KeyEvent.VK_UP)
                listComponent.add(new Line2D.Double(new Point2D.Double(x, y), new Point2D.Double(x, y - offset)));

            offset = 10;
            repaint();

        }

        public void keyReleased(KeyEvent e) {}
    }
}
