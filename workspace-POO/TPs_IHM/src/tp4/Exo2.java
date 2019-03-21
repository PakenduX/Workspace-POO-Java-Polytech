package tp4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Exo2
 * @author DEMBELE Mama
 */
public class Exo2 extends JFrame {

    JMenuItem rouge;
    JButton rouge_b;
    JButton rouge_b_item;
    JPanel container;

    public Exo2(){
        setTitle("Exo2");
        setBounds(30, 30, 700, 700);

        JMenuBar maBarre = new JMenuBar();

        JMenu fichier = new JMenu("Fichier");
        JMenu enregistrer = new JMenu("Enregistrer");
        JMenu affichage = new JMenu("Affichage");
        JMenu outils = new JMenu("Outils");

        JPopupMenu item = new JPopupMenu();

        JMenu externe = new JMenu("Externe");

        JMenuItem disque = new JMenuItem("Disque");
        JMenuItem derOption = new JMenuItem("DerOption");
        JMenuItem usb = new JMenuItem("USB");
        JMenuItem extDisque = new JMenuItem("ExtDisque");
        JMenuItem extExt = new JMenuItem("ExtExt");
        rouge = new JMenuItem("Rouge", new ImageIcon("/home/pkss/workspace-POO/TPs_IHM/src/tp4/rouge.png"));
        rouge.addActionListener(new Listener());
        rouge_b_item = new JButton("Rouge", new ImageIcon("/home/pkss/workspace-POO/TPs_IHM/src/tp4/rouge.png"));
        rouge_b_item.addActionListener(new Listener());

        JCheckBoxMenuItem caseC = new JCheckBoxMenuItem("CaseCocher");
        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("RB1");
        JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("RB2");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        JMenuItem item1 = new JMenuItem("Item1");
        JMenuItem item2 = new JMenuItem("Item2");
        item.add(item1);
        item.add(item2);
        item.add(rouge_b_item);

        rouge_b = new JButton("Rouge", new ImageIcon("/home/pkss/workspace-POO/TPs_IHM/src/tp4/rouge.png"));
        rouge_b.addActionListener(new Listener());
        enregistrer.add(disque);
        enregistrer.add(derOption);
        enregistrer.add(usb);
        enregistrer.add(externe);

        externe.add(extDisque);
        externe.add(rouge);
        externe.add(extExt);
        externe.add(caseC);
        externe.addSeparator();
        externe.add(rb1);
        externe.add(rb2);

        maBarre.add(fichier);
        maBarre.add(enregistrer);
        maBarre.add(affichage);
        maBarre.add(outils);

        setJMenuBar(maBarre);
        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(rouge_b, BorderLayout.SOUTH);
        add(container);
        //La fenêtre doit être rendue visible avant d'afficher le
        //popUpMenu
        setVisible(true);
        item.show(container, 500, 400);

    }

    class Listener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            container.setBackground(Color.RED);
        }
    }

    public static void main(String[] args){
        Exo2 e = new Exo2();
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
