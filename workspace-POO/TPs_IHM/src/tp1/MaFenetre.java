package tp1;

import javax.swing.*;
import java.awt.*;

/**
 * 1. Création de fenêtres
 * @author DEMBELE Mama
 */
public class MaFenetre extends JFrame {

    private MonPanneau p;

    public MaFenetre(String title, int x, int y, int larg, int haut){
        setTitle(title);
        setBounds(x, y, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        p = new MonPanneau();

        System.out.println("La taille de la fenetre = "+ this.getWidth() + " " + this.getHeight());
        System.out.println("Un nombre random " + (int)(Math.random()*this.getHeight()));
        setLayout(null);
        JLabel l = new JLabel("Mama");
        l.setBounds(0, 0, 100, 20);
        add(l);
        //add(p);

    }
}
