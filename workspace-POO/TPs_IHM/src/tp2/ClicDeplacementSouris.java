package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 5. Clic et déplacement de la souris
 */
public class ClicDeplacementSouris extends JPanel {

    private ArrayList<Rectangle2D> listRect;
    //Les dimensions de mes carrés
    private int width = 100;
    private int height = 100;
    // ce booléen indique le clique sur un coin
    // en déhors d'un carré.
    private boolean isClicked = false;
    // Pareil pour le double clic sur un carré.
    private boolean isDoubleClicked = false;
    //Ces variables stockent les positions x et y de la souris.
    private int triggerX = -1, triggerY = -1;
    Rectangle2D draggingRect;
    boolean isDragging = false;

    public ClicDeplacementSouris(){
        listRect = new ArrayList<>();
        addMouseListener(new SourisListener());
        addMouseMotionListener(new SourisDragger());
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        if (isClicked) {
            creerCarre(g2, triggerX, triggerY);
            isClicked = false;
        }else if(isDoubleClicked){
            supprimerCarre(g2, triggerX, triggerY);
            isDoubleClicked = false;
        }else if(isDragging){
            g2.draw(draggingRect);
            isDragging = false;
        }
    }

    /**
     * Cette méthode permet de créer un carré
     * @param g2 le graphique 2D
     * @param x la position x
     * @param y la position y.
     */
    public void creerCarre(Graphics2D g2, double x, double y){
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
        listRect.add(rect);
        g2.draw(rect);
    }

    /**
     * Cette méthode permet de supprimer un carré.
     * @param g2
     * @param x
     * @param y
     */
    public void supprimerCarre(Graphics2D g2, int x, int y) {
        System.out.println("list size avant= "+ listRect.size());
        listRect.remove(0);
        System.out.println("list size = "+ listRect.size());
        Iterator<Rectangle2D> it = listRect.iterator();
        while (it.hasNext()) {
            System.out.println("redessine");
            g2.draw(it.next());
        }

    }

    /**
     * Cette fonction sert à savoir si le clic a été fait à l'intérieur d'un
     * carré ou pas, si oui on renvoie le carré en question.
     * @param x la position x
     * @param y la position y
     * @return un rectangle2D dans lequel on a cliqué.
     */
    public Rectangle2D interieurCarre(int x, int y){
        Iterator<Rectangle2D> it = listRect.iterator();
        Rectangle2D r2d ;
        while (it.hasNext()){
            r2d = it.next();
            if((x >= r2d.getX() && x <= r2d.getX() + r2d.getWidth()) && (y >= r2d.getY() && y <= r2d.getY() + r2d.getHeight()))
                return r2d;
        }
        return null;
    }

    class SourisListener extends MouseAdapter {

        public void mouseClicked(MouseEvent me){
            Rectangle2D r = interieurCarre(me.getX(), me.getY());
            //Si c'est un double clic
            if(me.getClickCount() == 2){
                if(r != null){
                    isDoubleClicked = true;
                    triggerY = (int)r.getY();
                    triggerX = (int)r.getX();
                }
            }else{
                if (r == null) {
                    isClicked = true;
                    triggerY = me.getY();
                    triggerX = me.getX();
                }
            }

            repaint();
        }

    }

    class SourisDragger implements MouseMotionListener{

        public void mouseDragged(MouseEvent e) {
            Rectangle2D r = interieurCarre(e.getX(), e.getY());
            if(r != null){
                AffineTransform aft = new AffineTransform();
                Shape r_c = aft.createTransformedShape(r);
                isDragging = true;
                aft.translate(e.getX(), e.getY());
                draggingRect = new Rectangle2D.Double(r_c.getBounds().x, r_c.getBounds().y, width, height);
                repaint();
            }
        }

        public void mouseMoved(MouseEvent e) {
            Rectangle2D r = interieurCarre(e.getX(), e.getY());
            if(r != null){
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }else
                setCursor(Cursor.getDefaultCursor());
            repaint();
        }
    }
}
