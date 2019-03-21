package tp3;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Fenêtre d'Horloge
 * @author DEMBELE Mama
 */
public class HorlogeWindow extends JFrame {

    private HorlogePanel hp;
    private JTextField h_field;
    private JTextField min_field;

    public HorlogeWindow(){
        setTitle("Horloge");
        setSize(400, 450);
        setLocationRelativeTo(null);

        hp = new HorlogePanel();

        JLabel h_label = new JLabel("Heures:");
        JLabel min_label = new JLabel("Minutes:");
        h_field = new JTextField();
        min_field = new JTextField();
        h_field.setPreferredSize(new Dimension(50, 25));
        min_field.setPreferredSize(new Dimension(50, 25));

        min_field.getDocument().addDocumentListener(new MyDocumentListener());
        h_field.getDocument().addDocumentListener(new MyDocumentListener());

        setLayout(new BorderLayout());
        JPanel bas = new JPanel();
        bas.setLayout(new FlowLayout());
        bas.add(h_label);
        bas.add(h_field);
        bas.add(min_label);
        bas.add(min_field);

        add(bas, BorderLayout.SOUTH);
        add(hp);


    }

    class MyDocumentListener implements DocumentListener{

        public void insertUpdate(DocumentEvent e) {
            try{
                hp.setHeure(Integer.parseInt(h_field.getText()));
            }catch (NumberFormatException nfe){
                System.out.println("Problème de saisie");
            }
            try{
                hp.setMinutes(Integer.parseInt(min_field.getText()));
            }catch (NumberFormatException nfe){
                System.out.println("Problème de saisie");
            }
            repaint();
        }

        public void removeUpdate(DocumentEvent e) {
            //Si le champ de texte heure est vide
            // je met l'heure à 12h
            if(!h_field.getText().equals("")){
                try{
                    hp.setHeure(Integer.parseInt(h_field.getText()));
                }catch (NumberFormatException nfe){
                    System.out.println("Problème de saisie");
                }
            }else
                hp.setHeure(12);

            //Pareil pour minutes à 0.
            if(!min_field.getText().equals("")){
                try{
                    hp.setMinutes(Integer.parseInt(min_field.getText()));
                }catch (NumberFormatException nfe){
                    System.out.println("Problème de saisie");
                }
            }else
                hp.setMinutes(0);

            repaint();
        }

        public void changedUpdate(DocumentEvent e) {}
    }


    public static void main(String[] args){
        HorlogeWindow hw = new HorlogeWindow();
        hw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hw.setVisible(true);
    }
}
