package tp1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 2. Dessin
 * @author DEMBELE Mama
 */
public class MonPanneau extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Le rectangle positionné à x = 50, y = 50 de largeur = 150 et hauteur = 100.
        Rectangle2D rect = new Rectangle2D.Double(50, 50, 150, 100);
        g2.draw(rect);

        //On dessine la chaîne en partant du centre du rectangle.
        g2.drawString("HELLO", (int)rect.getCenterX(), (int)rect.getCenterY());

        //Ellipse remplie de couleur rouge inscrite dans le rectangle précédent.
        Ellipse2D e = new Ellipse2D.Double();
        e.setFrame(rect);
        g2.setPaint(Color.RED);
        g2.fill(e);

        //La diagonale de couleur bleue du rectangle.
        Line2D diag = new Line2D.Double(new Point2D.Double(150, 150), new Point2D.Double(200, 150));
        g2.setPaint(Color.BLUE);
        g2.draw(diag);

        //RectangularShape permet d'utiliser la méthode setFrameFromCenter qui permet de dessiner le
        //cercle en donnant le centre et un des quatre coins.
        RectangularShape cercle = new Ellipse2D.Double();
        cercle.setFrameFromCenter(rect.getCenterX(), rect.getCenterY(), rect.getCenterX()-100, rect.getCenterY()-100);
        g2.setPaint(Color.BLACK);
        g2.draw(cercle);

        //Pour translater notre cercle on fait une copie qu'on translate
        AffineTransform aft = new AffineTransform();
        aft.translate(300, 300);
        Shape cercle_trans = aft.createTransformedShape(cercle);
        g2.draw(cercle_trans);

        //Pareil pour la rotation du rectangle
        AffineTransform aft2 = new AffineTransform();
        aft2.rotate(Math.toRadians(45), rect.getX(), rect.getY());
        Shape rect_rotate = aft2.createTransformedShape(rect);
        g2.draw(rect_rotate);

        //Pour changer la couleur de l'éllipse on la remplit de blanc et on la redessine
        // avec le rouge transparent.
        g2.setPaint(Color.WHITE);
        g2.fill(e);
        g2.setPaint(new Color(255, 0, 0, 50));
        g2.fill(e);


        g2.setPaint(Color.WHITE);
        g2.fill(e);
        //Ici je récupère les points de départ et d'arriver grâce au rectangle
        //imaginaire dans lequel est inscrit l'éllipse.
        Point2D dep = new Point2D.Double(e.getBounds2D().getX(), e.getBounds2D().getY());
        Point2D arr = new Point2D.Double(e.getBounds2D().getX() + e.getBounds2D().getWidth()/2, e.getBounds2D().getY());
        GradientPaint gp = new GradientPaint(dep, Color.RED, arr, Color.YELLOW);
        g2.setPaint(gp);
        g2.fill(e);

        try {
            BufferedImage img = ImageIO.read(new File("/home/pkss/workspace-POO/TPs_IHM/src/tp2/la-planete-jupiter.jpg"));
            TexturePaint tp = new TexturePaint(img, e.getBounds2D());
            g2.setPaint(tp);
            g2.fill(e);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //Changement de l'épaisseur du cercle et du rectangle.
        g2.setPaint(Color.BLACK);
        g2.setStroke(new BasicStroke(23));
        g2.draw(cercle_trans);

        g2.setStroke(new BasicStroke(23));
        g2.draw(rect_rotate);

    }

}
