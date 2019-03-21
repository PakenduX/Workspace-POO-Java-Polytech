package tp2;

import javax.swing.*;

public class DessinAvecClavierFrame extends JFrame {

    private DessinAvecClavier dac;

    public DessinAvecClavierFrame(){
        setTitle("Dessin avec le clavier");
        setBounds(50, 50, 700, 700);

        dac = new DessinAvecClavier();
        dac.setFocusable(true);
        add(dac);


    }
}
