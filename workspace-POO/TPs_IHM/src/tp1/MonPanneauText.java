package tp1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 3. Fontes, Images
 * @author DEMBELE Mama
 */
public class MonPanneauText extends JPanel {

    public void paintComponent(Graphics g){

        String texte1 = "Le hackeur a pris le contrôle,";
        String texte2 = "Faites gaffe";

        g.drawString(texte1, 100, 100);
        FontMetrics fm = g.getFontMetrics();
        int larg = fm.stringWidth(texte1);
        int haut = fm.getHeight();
        //On positionne le 2ème texte à (largeur du premier + son abscisse ).
        g.drawString(texte2, larg + 100, 100);
        //On positionne le 2ème texte à (hauteur du premier + son ordonnée ).
        g.drawString(texte2, 100, haut + 100);

        //L'image est dessinée avec une hauteur de 250px et largeur de 300px
        try {
            BufferedImage img = ImageIO.read(new File("/home/pkss/workspace-POO/TPs_IHM/src/tp2/la-planete-jupiter.jpg"));
            g.drawImage(img, 200, 200, 300, 250, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
