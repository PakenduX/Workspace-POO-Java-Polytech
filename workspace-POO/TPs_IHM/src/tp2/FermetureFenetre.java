package tp2;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 2. Fermeture d'une fenêtre.
 */
public class FermetureFenetre extends JFrame {

    public FermetureFenetre(){
        setTitle("Fenetre d'une fenêtre");
        setBounds(30, 30, 700, 700);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(FermetureFenetre.this, "Voulez-vous arrêter" +
                        "le programme ?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if(option == JOptionPane.YES_OPTION)
                    System.exit(0);

            }
        });
    }
}
