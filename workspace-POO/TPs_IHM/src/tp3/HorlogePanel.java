package tp3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * La classe de dessin de l'horloge
 * @author DEMBELE Mama
 */
public class HorlogePanel extends JPanel {

    /**
     * Je met l'horloge à 12:00 par defaut
     */
    private int heure = 12;
    private int minutes = 0;

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D cercle = new Ellipse2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        // 1 min correspond à 6°
        // 1h correspond à 30°
        int angleMin = (minutes*6)%360;
        //On ajuste l'heure de telle sorte qu'elle bouge en même temps que
        // la minute pour avoir une horloge presque parfaite.
        int angleH = (heure*30 + minutes/2)%360;

        Rectangle2D cercle_rect_img = cercle.getBounds2D();
        AffineTransform aft = new AffineTransform();
        AffineTransform aft2 = new AffineTransform();
        Line2D lmin = new Line2D.Double(cercle_rect_img.getCenterX(), cercle_rect_img.getCenterY(), cercle_rect_img.getCenterX(), 30);
        Line2D lh = new Line2D.Double(cercle_rect_img.getCenterX(), cercle_rect_img.getCenterY(), cercle_rect_img.getCenterX(), 60);

        aft.rotate(Math.toRadians(angleMin), cercle_rect_img.getCenterX(), cercle_rect_img.getCenterY());
        Shape lmin_c = aft.createTransformedShape(lmin);
        aft2.rotate(Math.toRadians(angleH), cercle_rect_img.getCenterX(), cercle_rect_img.getCenterY());
        Shape lh_c = aft2.createTransformedShape(lh);
        g2.draw(cercle);
        g2.draw(lh_c);
        g2.draw(lmin_c);
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
