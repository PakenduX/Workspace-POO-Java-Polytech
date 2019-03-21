package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FermetureSimulataneeFenetre extends JFrame {

    ArrayList<Window> wins = new ArrayList<>();
    public FermetureSimulataneeFenetre(){
        setTitle("Fermeture simultanée de fenêtre");
        setBounds(0, 0, 300, 200);

        JButton creer = new JButton("CRÉER");
        JButton fermer = new JButton("FERMER");

        setLayout(new FlowLayout());
        add(creer);
        add(fermer);

        wins.add(this);


        creer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                f.setTitle("fenetre");
                f.setBounds(wins.get(wins.size()-1).getX() + 305, wins.get(wins.size()-1).getY(), 300, 200);
                wins.add(f);
                f.setVisible(true);
            }
        });

        fermer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                for(Window w : wins) {
                    w.dispose();
                    fermer.removeActionListener(this);
                }
            }
        });
    }

    public static void main(String[] args){
        new FermetureSimulataneeFenetre().setVisible(true);
    }
}
