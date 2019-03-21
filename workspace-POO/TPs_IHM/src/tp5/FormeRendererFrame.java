package tp5;

import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre contenant notre JList
 * @author DEMBELE Mama
 */
public class FormeRendererFrame extends JFrame {

    public FormeRendererFrame(){
        setTitle("Renderer personnalisé de JList");
        setSize(300, 150);
        setLocationRelativeTo(null);

        JList jl = new JList(new String[]{"Carre", "Cercle", "Segment"});

        //On change le renderer de la JList en notre renderer.
        jl.setCellRenderer(new FormeRenderer());

        setLayout(new FlowLayout());

        JScrollPane jsp = new JScrollPane(jl);

        add(jsp);
    }

    public static void main(String[] args){
        FormeRendererFrame frf = new FormeRendererFrame();
        frf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frf.setVisible(true);
    }
}
