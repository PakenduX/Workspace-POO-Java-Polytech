package tp1;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){

        /*
        *   1. Création de fenêtres
        *       1.1 Fenêtre centrée en haut à gauche
        */

        MaFenetre f = new MaFenetre("MyWindow", 0, 0, 700, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        /*
         *  1.2 Fenêtre centrée au milieu de l'écran et occupant
         *  un quart de l'écran.
         */
       /* Toolkit tk = Toolkit.getDefaultToolkit();
        MaFenetre f2 = new MaFenetre("MyWindow2", tk.getScreenSize().width/4, tk.getScreenSize().height/4, tk.getScreenSize().width/2, tk.getScreenSize().height/2);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setVisible(true);

        /*
         *   2. Dessin
         */

        /*MaFenetre f3 = new MaFenetre("MyWindow", 0, 0, 700, 700);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.setVisible(true);

        /*
         *   3. Fontes, Images
         */

        /*MonPanneauTextFrame mptf = new MonPanneauTextFrame();
        mptf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mptf.setVisible(true);*/
    }
}
