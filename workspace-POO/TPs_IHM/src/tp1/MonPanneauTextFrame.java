package tp1;

import javax.swing.*;

public class MonPanneauTextFrame extends JFrame {

    private MonPanneauText p;
    public MonPanneauTextFrame(){
        setTitle("Fontes, Images");
        setBounds(10, 10, 700, 700);

        p = new MonPanneauText();
        add(p);
    }
}
