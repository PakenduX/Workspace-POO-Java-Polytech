package tp2;

import javax.swing.*;

/**
 * 4. La fenêtre contenant le panneau de dessin avec clavier.
 */
public class ClicDeplacementSourisFrame extends JFrame {

    private ClicDeplacementSouris panel;

    public ClicDeplacementSourisFrame(){
        setTitle("Clic et déplacement avec la souris");
        setBounds(60, 60, 700, 700);

        panel = new ClicDeplacementSouris();
        add(panel);

    }
}
